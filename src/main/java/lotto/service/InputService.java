package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class InputService {

    InputView inputView;

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
