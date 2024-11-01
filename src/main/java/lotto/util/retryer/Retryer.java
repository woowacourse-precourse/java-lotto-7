package lotto.util.retryer;

import lotto.exception.CustomException;

public class Retryer {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static <T> T retryOnCustomException(SupplierWithException<T> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            handleException(e);
            return retryOnCustomException(supplier);
        }
    }

    public static void retryOnCustomException(RunnableWithException runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            handleException(e);
            retryOnCustomException(runnable);
        }
    }

    public static void handleException(RuntimeException e) throws RuntimeException {
        if (e instanceof CustomException) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return;
        }
        throw e;
    }

    @FunctionalInterface
    public interface SupplierWithException<T> {
        T get() throws RuntimeException;
    }

    @FunctionalInterface
    public interface RunnableWithException {
        void run() throws RuntimeException;
    }
}
