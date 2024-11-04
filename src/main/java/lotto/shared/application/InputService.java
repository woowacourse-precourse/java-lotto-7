package lotto.shared.application;

import lotto.checker.domain.BonusNumber;
import lotto.purchase.domain.Money;
import lotto.checker.domain.WinningNumbers;
import lotto.view.InputView;

public class InputService {

    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public Money getMoney() {
        return inputView.getMoney();
    }

    public WinningNumbers getWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    public BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        return inputView.getBonusNumber(winningNumbers);
    }
}
