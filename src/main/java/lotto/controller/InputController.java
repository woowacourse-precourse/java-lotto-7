package lotto.controller;

import lotto.model.*;
import lotto.util.InputValidator;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputController(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public Money getMoney() {
        while (true) {
            try {
                String input = inputView.readMoney();
                return new Money(input, inputValidator);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }

    public WinningInfo getWinningInfo() {
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        return new WinningInfo(winningNumbers, bonusNumber);
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return new WinningNumbers(input, inputValidator);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                return new BonusNumber(input, winningNumbers, inputValidator);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }
}
