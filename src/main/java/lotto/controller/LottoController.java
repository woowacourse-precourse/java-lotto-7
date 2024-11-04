package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.domain.Validator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int purchaseAmount = inputPurchaseAmount();

        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);
        OutputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Map<Rank, Integer> results = winningLotto.calculateResults(lottos);
        OutputView.printWinningStatistics(results);

        double yield = winningLotto.calculateYield(results, purchaseAmount);
        OutputView.printYield(yield);
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = InputView.inputWinningNumbers();
                return Validator.validateAndParseWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                return Validator.validateAndParseBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmountInput = InputView.inputPurchase();
                return Validator.validateAndParsePurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
