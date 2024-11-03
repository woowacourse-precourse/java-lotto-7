package lotto.commons.util;

import java.util.function.Supplier;
import lotto.commons.lang.ProgramExitException;
import lotto.commons.logger.Logger;

public class Handler {

    private Handler() {}

    public static <T> T runCatching(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (ProgramExitException e) {
            throw e;
        } catch (Throwable t) {
            Logger.error(t.getMessage());
            return null;
        }
    }
}
