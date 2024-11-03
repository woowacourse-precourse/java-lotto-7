package lotto.util;

import lotto.exception.ErrorMessages;
import lotto.exception.MaxRetryExceededException;

public class RetryHandler {
    private final int maxRetries;

    public RetryHandler(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public <T> T execute(SupplierWithException<T> supplier) {
        int attempts = 0;

        while (attempts < maxRetries) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }

        throw new MaxRetryExceededException(ErrorMessages.MAX_RETRY_EXCEEDED);
    }

    @FunctionalInterface
    public interface SupplierWithException<T> {
        T get() throws IllegalArgumentException;
    }
}

