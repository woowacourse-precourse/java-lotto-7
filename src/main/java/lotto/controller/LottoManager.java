package lotto.controller;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.WinningRank;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private InputView inputView = new InputView();
    private InputValidator inputValidator = new InputValidator();
    private InputParser inputParser = new InputParser();
    private OutputView outputView = new OutputView();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private LottoRepository lottoRepository = new LottoRepository();

    public void startLotto() {
        int purchasePrice = getPurchasePrice();
        creatLottos(purchasePrice);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        Map<WinningRank, Integer> rankCount = calculateWinningStatistic(winningNumbers, bonusNumber,
                purchasePrice);
        int totalPrize = printWinningStatistic(rankCount);
        double rate = Math.round(((double) totalPrize / purchasePrice * 10000)) / 100.0;
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    private Map<WinningRank, Integer> calculateWinningStatistic(List<Integer> winningNumbers, int bonusNumber,
                                                                int purchasePrice) {
        outputView.printWinningStatisticHead();
        List<Lotto> lottos = lottoRepository.findAll();

        Map<WinningRank, Integer> rankCountMap = new EnumMap<>(WinningRank.class);
        for (WinningRank rank : WinningRank.values()) {
            rankCountMap.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            calculateRank(winningNumbers, bonusNumber, lotto, rankCountMap);
        }

        return rankCountMap;
    }

    private int printWinningStatistic(Map<WinningRank, Integer> rankCountMap) {
        int totalPrize = 0;
        for (Map.Entry<WinningRank, Integer> entry : rankCountMap.entrySet()) {
            if (entry.getKey() != WinningRank.ZERO) {
                outputView.printWinningStatisticBody(entry);
                totalPrize += entry.getKey().getPrize() * entry.getValue();
            }
        }
        return totalPrize;
    }

    private void calculateRank(List<Integer> winningNumbers, int bonusNumber, Lotto lotto,
                               Map<WinningRank, Integer> rankCountMap) {
        List<Integer> numbers = lotto.getNumbers();
        int count = 0;
        boolean bonus = false;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        if (count == 5 && numbers.contains(bonusNumber)) {
            bonus = true;
        }

        WinningRank rank = WinningRank.getRank(count, bonus);
        rankCountMap.put(rank, rankCountMap.get(rank) + 1);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumberResult = 0;
        while (true) {
            try {
                String bonusNumber = inputView.getBonusNumber();
                inputValidator.validateBonusNumber(bonusNumber, winningNumbers);
                bonusNumberResult = inputParser.parseBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return bonusNumberResult;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumberList = new ArrayList<>();
        while (true) {
            try {
                String winningNumbers = inputView.getWinningNumbers();
                inputValidator.validateWinningNumbers(winningNumbers);
                winningNumberList = inputParser.parseWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return winningNumberList;
    }

    private void creatLottos(int purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        outputView.printCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = lottoNumberGenerator.generate();
            List<Integer> sortedLottoNumber = lottoNumber.stream()
                    .sorted()
                    .collect(Collectors.toList());
            outputView.printLottoNumber(sortedLottoNumber);
            lottoRepository.save(new Lotto(sortedLottoNumber));
        }
        outputView.printBlank();
    }

    private int getPurchasePrice() {
        int parsedPurchasePrice = 0;
        while (true) {
            try {
                String purchasePrice = inputView.getPurchasePrice();
                inputValidator.validatePurchasePrice(purchasePrice);
                parsedPurchasePrice = inputParser.parsePurchasePrice(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return parsedPurchasePrice;
    }
}
