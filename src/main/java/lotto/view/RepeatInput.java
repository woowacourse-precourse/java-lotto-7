package lotto.view;

import java.util.function.Supplier;

public class RepeatInput {

    public static <T> T getValidInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
