package lotto.util;

import lotto.view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public class InputHandler {

    private InputHandler() {
    }

    public static <T> T readUntilValid(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return readUntilValid(supplier);
        }
    }

    public static <T, R> R readUntilValid(Function<T, R> function, T input) {
        try {

            return function.apply(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return readUntilValid(function, input);
        }
    }
}
