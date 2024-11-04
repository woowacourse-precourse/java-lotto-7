package lotto.common.util;

import java.util.function.Supplier;

public interface InteractionRepeatable {

    String RETRY_MESSAGE_HEADER = "[ERROR] ";

    default void runWithRetry(final Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RETRY_MESSAGE_HEADER + e.getMessage());
            }
        }
    }

    default <T> T supplyWithRetry(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(RETRY_MESSAGE_HEADER + e.getMessage());
            }
        }
    }

}
