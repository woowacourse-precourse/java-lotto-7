package lotto.handler;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.view.output.ErrorView;

public class InputHandler {

    public static <T> T handle(Supplier<String> inputSupplier, Function<String, T> wrapper) {
        while (true) {
            try {
                String input = inputSupplier.get();
                return wrapper.apply(input);
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e.getMessage());
            }
        }
    }

}
