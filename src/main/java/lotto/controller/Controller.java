package lotto.controller;

import lotto.domain.JackpotNumbers;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.util.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {

    private final Validator inputPurchaseAmountValidator = new InputPurchaseAmountValidator();
    private final Validator inputJackpotNumbersValidator = new InputJackpotNumbersValidator();

    public void run() {
        int totalAmount;
        while (true) {
            String inputTotalAmount = InputView.requestAmountToPurchase();
            OutputView.lineBreaking();
            try {
                inputPurchaseAmountValidator.validate(inputTotalAmount);
                totalAmount = Integer.parseInt(inputTotalAmount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        int lottoCount = totalAmount / 1000;
        List<Lotto> purchasedLottos = LottoListGenerator.generateLottos(lottoCount);
        OutputView.printPurchasedLottos(lottoCount, purchasedLottos);
        OutputView.lineBreaking();

        JackpotNumbers jackpotNumbers = new JackpotNumbers();
        while (true) {
            String inputJackpotNumbers = InputView.requestJackpotNumbers();
            OutputView.lineBreaking();
            try {
                inputJackpotNumbersValidator.validate(inputJackpotNumbers);
                List<Integer> intList = StringParser.toIntList(inputJackpotNumbers);
                Lotto jackpot = new Lotto(intList);
                jackpotNumbers.setLotto(jackpot);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        while (true) {
            String inputBonusNumber = InputView.requestBonusNumber();
            OutputView.lineBreaking();
            try {
                int bonusNumber = StringParser.toInt(inputBonusNumber);
                jackpotNumbers.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        Map<Ranking, Integer> rankingMap = RankingEvaluator.evaluateAll(purchasedLottos, jackpotNumbers);
        OutputView.printWinningStatistics(rankingMap);
        double earningRate = EarningRateCalculator.calculate(totalAmount, rankingMap);
        OutputView.printEarningRate(earningRate);
    }
}
