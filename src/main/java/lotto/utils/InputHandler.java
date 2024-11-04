package lotto.utils;

import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.InputMoney;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public InputMoney getInputMoney() {
        return retryInput(() -> new InputMoney(inputView.getUserInputMoney()));
    }

    public WinningNumbers getWinningNumbers() {
        return retryInput(() -> new WinningNumbers(inputView.getWinningNumbers()));
    }

    public BonusNumber getBonusNumber() {
        return retryInput(() -> new BonusNumber(inputView.getBonusNumber()));
    }

    private <T> T retryInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(Constant.ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }
}