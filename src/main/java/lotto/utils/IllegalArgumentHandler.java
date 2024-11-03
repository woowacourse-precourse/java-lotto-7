package lotto.utils;

import java.util.function.Supplier;

public class IllegalArgumentHandler<T> {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public T doUntilNoOccur(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }
}
