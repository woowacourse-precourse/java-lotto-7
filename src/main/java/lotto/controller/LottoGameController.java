package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Money;
import lotto.exception.InputException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void run() {
        Money money = repeatUntilReadValidInput(this::readMoney);
    }

    private Money readMoney() {
        OutputView.askPurchasePrice();
        return Money.from(InputView.readInput());
    }

    private <T> T repeatUntilReadValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (InputException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
    }
}
