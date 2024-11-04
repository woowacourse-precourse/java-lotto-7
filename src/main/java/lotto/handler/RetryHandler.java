package lotto.handler;

import java.util.function.Function;
import java.util.function.Supplier;

public class RetryHandler {
    public <T> T retryUntilNoException(Supplier<T> logic) {
        while (true) {
            try {
                return logic.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public <T, R> R retryUntilNoException(Function<T, R> logic, T data) {
        while (true) {
            try {
                return logic.apply(data);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
