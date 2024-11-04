package lotto.utils;

import lotto.view.OutputView;
import java.util.function.Supplier;

public class InputRetryHandler {

    public static <T> T handleInput(Supplier<T> inputSupplier, OutputView outputView) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
