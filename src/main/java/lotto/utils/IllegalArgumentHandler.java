package lotto.utils;

import java.util.function.Supplier;

public class IllegalArgumentHandler<T> {
    public T doUntilNoOccur(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
