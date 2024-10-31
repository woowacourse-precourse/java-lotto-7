package lotto.utils;

import java.util.function.Supplier;
import lotto.exception.LottoException;

public class LottoExceptionUtils {

    public static <T> T runUntilNoneLottoException(Supplier<T> task) {
        while (true) {
            try {
                return task.get();
            } catch (LottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
