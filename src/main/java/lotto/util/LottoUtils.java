package lotto.util;

import java.util.function.Supplier;

public class LottoUtils {
    public static <T> T inputLoop(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
