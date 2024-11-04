package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
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
}
