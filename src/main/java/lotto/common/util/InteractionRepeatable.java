package lotto.common.util;

import java.util.function.Supplier;

public interface InteractionRepeatable {

    String RETRY_MESSAGE_HEADER = "[ERROR] ";

    default void runWithTry(final Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RETRY_MESSAGE_HEADER + e.getMessage());
            }
        }
    }

    default <T> T supplyWithTry(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(RETRY_MESSAGE_HEADER + e.getMessage());
            }
        }
    }

}
