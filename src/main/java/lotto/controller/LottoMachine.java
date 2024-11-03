package lotto.controller;

import static lotto.domain.WinningStatistics.calculateEarningRate;
import static lotto.domain.WinningStatistics.checkWinningResult;
import static lotto.view.OutputView.printMessage;

import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.Purchaser;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void run() {
        Budget budget = inputBudget();
        Purchaser purchaser = new Purchaser(budget);
        OutputView.displayPurchasedLottoNumbers(purchaser.getPurchasedLotto());

        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        checkWinningResult(purchaser, winningNumbers, bonusNumber);
        double earningRate = calculateEarningRate(budget);
        OutputView.displayWinningStatistics(earningRate);
    }

    private Budget inputBudget() {
        while (true) {
            try {
                return new Budget(InputView.readBudget());
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(WinningNumbers numbers) {
        while (true) {
            try {
                return new BonusNumber(InputView.readBonusNumber(), numbers);
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }
}
