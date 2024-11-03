package lotto.controller;

import java.util.function.Supplier;
import lotto.exception.InputException;
import lotto.view.OutputView;

public class LottoGameController {
    public void run() {
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
