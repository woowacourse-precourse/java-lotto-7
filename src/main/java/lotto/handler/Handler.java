package lotto.handler;

import static lotto.view.OutputView.printMessage;

import java.util.function.Supplier;

public class Handler {
    private Handler() {
    }

    public static <T> T repeatInputUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }
}
