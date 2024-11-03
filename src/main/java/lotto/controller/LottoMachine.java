package lotto.controller;

import static lotto.view.OutputView.printMessage;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.WinningInfo;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private List<Lotto> purchasedLotto;

    public LottoMachine() {
        purchasedLotto = new ArrayList<>();
    }

    public void run() {
        Budget budget = inputBudget();
        purchaseLotto(budget);
        OutputView.displayPurchasedLottoNumbers(purchasedLotto);

        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        checkWinningResult(winningNumbers, bonusNumber);
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

    private void purchaseLotto(Budget budget) {
        int lottoQuantity = budget.getAmount() / LottoInfo.PRICE;
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = LottoNumbersGenerator.generate();
            purchasedLotto.add(new Lotto(numbers));
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

    private void checkWinningResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
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
