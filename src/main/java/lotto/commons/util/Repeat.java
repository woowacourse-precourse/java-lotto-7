package lotto.commons.util;

import java.util.function.Supplier;
import lotto.commons.lang.InputOverFlowException;

public class Repeat {

    private Repeat() {}

    public static <T> T doWhile(int repeat, Supplier<T> supplier) {
        T result;
        int count = 0;
        do {
            if (++count > repeat) {
                throw new InputOverFlowException();
            }
            result = Handler.runCatching(supplier);
        } while (result == null);
        return result;
    }
}
