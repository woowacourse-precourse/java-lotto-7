package lotto.utils;

import java.util.function.Supplier;

public class RetryUtil {

    public static <T> T retry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retry(supplier);
        }
    }
}
