package lotto.utils;

import java.util.function.Supplier;

public class ExceptionUtils {

    public static <T> T runUntilNoneIllegalArgumentException(Supplier<T> task) {
        while (true) {
            try {
                return task.get();
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
