package lotto.util;

import java.util.function.Supplier;

public class RepeatInput {
    public static <T> T repeatUntilValid(Supplier<T> function, CommonIo commonIo) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            commonIo.printMessage(e.getMessage());
            return repeatUntilValid(function, commonIo);
        }
    }
}
