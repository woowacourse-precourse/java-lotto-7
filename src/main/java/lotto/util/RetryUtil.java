package lotto.util;

import java.util.function.Supplier;

public class RetryUtil {
    private static final String ERROR = "[Error] ";

    public static <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }
}
