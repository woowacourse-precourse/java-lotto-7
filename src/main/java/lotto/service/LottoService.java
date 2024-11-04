package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.repository.LottoRepository;
import lotto.validation.InputValidation;
import lotto.validation.PurchasePriceValidation;
import lotto.validation.WinningNumbersValidation;

public class LottoService {

    private final InputValidation inputValidation;
    private final PurchasePriceValidation purchasePriceValidation;
    private final LottoRepository lottoRepository;
    private final WinningNumbersValidation winningNumbersValidation;

    public LottoService() {
        this.inputValidation = new InputValidation();
        this.purchasePriceValidation = new PurchasePriceValidation();
        this.lottoRepository = new LottoRepository();
        this.winningNumbersValidation = new WinningNumbersValidation();
    }

    public int validatePurchasePrice(String purchasePriceInput) throws IllegalArgumentException {
        inputValidation.checkNotNullAndNotBlank(purchasePriceInput);
        inputValidation.checkIsInteger(purchasePriceInput);

        int purchasePrice = Integer.parseInt(purchasePriceInput);

        purchasePriceValidation.checkRange(purchasePrice);
        purchasePriceValidation.validateDivisibleByThousand(purchasePrice);
        lottoRepository.insertPurchasePrice(purchasePrice);

        return purchasePrice / 1000;
    }

    public void generateLottoNumbers(int purchaseAmount) {
        while (purchaseAmount > 0) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoRepository.insertNumbers(randomNumbers);
            purchaseAmount--;
        }
    }

    public Set<List<Integer>> getLottoTickets() {
        return lottoRepository.getLottoTickets();
    }

    public List<Integer> validateWinningNumbers(String winningNumbersInput)
            throws IllegalArgumentException {
        inputValidation.checkNotNullAndNotBlank(winningNumbersInput);

        String[] winningNumbers = winningNumbersInput.split(",");

        List<Integer> lotto = new ArrayList<>();

        for (String number : winningNumbers) {
            number = number.trim();
            inputValidation.checkIsInteger(number);

            int winningNumber = Integer.parseInt(number);
            winningNumbersValidation.checkRange(winningNumber);

            lotto.add(winningNumber);
        }

        return lotto;
    }

    public void generateWinningLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottoRepository.insertWinningLotto(lotto);
    }

    public int validateBonusNumber(String bonusNumberInput) throws IllegalArgumentException {
        inputValidation.checkNotNullAndNotBlank(bonusNumberInput);
        inputValidation.checkIsInteger(bonusNumberInput);

        int bonusNumber = Integer.parseInt(bonusNumberInput);

        winningNumbersValidation.checkRange(bonusNumber);
        winningNumbersValidation.checkDuplicateNumber(lottoRepository.getWinningLotto(),
                bonusNumber);
        return bonusNumber;
    }

    public void saveBonusNumber(int bonusNumber) {
        lottoRepository.insertBonusNumber(bonusNumber);
    }

    public void calculateWinningNumbers() {
        Set<List<Integer>> lottoTickets = lottoRepository.getLottoTickets();
        List<Integer> winningNumbers = lottoRepository.getWinningLotto();
        long matchCount;

//        Map<LottoRank, Integer> test = lottoRepository.getWinningResults();

        for (List<Integer> lottoTicket : lottoTickets) {
            matchCount = lottoTicket.stream()
                    .filter(winningNumbers::contains)
                    .count();

            if (matchCount == 5) {
                calculateBonusNumber(lottoTicket);
                return;
            }
            insertMatchCount(matchCount);
//            System.out.println("개수: " + matchCount);
//            for (LottoRank lottoRank : test.keySet()) {
//                System.out.println(lottoRank.name() + ": " + test.get(lottoRank));
//            }
        }

    }

    public void insertMatchCount(long matchCount) {
        if (matchCount == 6) {
            lottoRepository.insertMatchCount(LottoRank.FIRST);
            return;
        }
        if (matchCount == 4) {
            lottoRepository.insertMatchCount(LottoRank.FOURTH);
            return;
        }
        if (matchCount == 3) {
            lottoRepository.insertMatchCount(LottoRank.FIFTH);
        }
    }

    public void calculateBonusNumber(List<Integer> lottoTicket) {
        int bonusNumber = lottoRepository.getBonusNumber();

        if (lottoTicket.contains(bonusNumber)) {
            lottoRepository.insertMatchCount(LottoRank.SECOND);
            return;
        }
        lottoRepository.insertMatchCount(LottoRank.FOURTH);
    }

    public int getMatchedCount(LottoRank value) {
        Map<LottoRank, Integer> winningResults = lottoRepository.getWinningResults();
        return winningResults.getOrDefault(value, 0);
    }

    public float calculateProfitRate() {
        Map<LottoRank, Integer> winningResults = lottoRepository.getWinningResults();
        int purchasePrice = lottoRepository.getPurchasePrice();

        int totalMatchedPrice = 0;

        for (LottoRank lottoRank : winningResults.keySet()) {
            int matchedCount = winningResults.getOrDefault(lottoRank, 0);
            totalMatchedPrice += lottoRank.getPrize() * matchedCount;
        }

        float profitRate = ((float) totalMatchedPrice / purchasePrice) * 100;
        return Math.round(profitRate * 10) / 10.0f;
    }
}
