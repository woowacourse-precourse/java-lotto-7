package lotto;

import java.util.function.Supplier;

public class Util {
    public static <T> T tryGetUntilSuccess(Supplier<T> supplier, Runnable trialSeparator) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                IoCContainer.getIoManager().printMessage(e.getMessage());
            } finally {
                trialSeparator.run();
            }
        }
    }
}
