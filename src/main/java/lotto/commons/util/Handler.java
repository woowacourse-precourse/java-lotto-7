package lotto.commons.util;

import java.util.function.Supplier;
import lotto.commons.logger.Logger;

public class Handler {

    public static <T> T runCatching(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Throwable t) {
            Logger.error(t.getMessage());
            return null;
        }
    }
}
