package lotto.controller;

import static lotto.view.OutputView.printMessage;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Purchaser;
import lotto.domain.WinningInfo;
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

    private void checkWinningResult(Purchaser purchaser, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Lotto> purchasedLotto = purchaser.getPurchasedLotto();
        for (Lotto lotto : purchasedLotto) {
            int place = lotto.findPlace(winningNumbers, bonusNumber);
            updateWinningTicketCount(place);
        }
    }

    private void updateWinningTicketCount(int place) {
        for (WinningInfo info : WinningInfo.values()) {
            if (place == info.getPlace()) {
                info.win();
            }
        }
    }

    private double calculateEarningRate(Budget budget) {
        int amount = budget.getAmount();
        int earnings = 0;
        for (WinningInfo info : WinningInfo.values()) {
            earnings += info.getPrizeMoney() * info.getWinningTicketCount();
        }
        return (double) earnings / amount * 100;
    }
}
