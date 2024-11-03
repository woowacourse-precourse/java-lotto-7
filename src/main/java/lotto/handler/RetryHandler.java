package lotto.handler;

import java.util.function.Function;
import java.util.function.Supplier;

public class RetryHandler {
    public <T> T retry(Supplier<T> logic) {
        boolean retryFlag = true;
        T result = null;
        while (retryFlag) {
            try {
                result = logic.get();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public <T, R> R retry(Function<T, R> logic, T data) {
        boolean retryFlag = true;
        R result = null;
        while (retryFlag) {
            try {
                result = logic.apply(data);
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
