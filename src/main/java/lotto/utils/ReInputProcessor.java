package lotto.utils;

import java.util.function.Supplier;

public class ReInputProcessor {

    private ReInputProcessor() {
    }

    @SafeVarargs
    public static <T> T execute(Supplier<T> supplier, Class<? extends Exception>... expectedExceptions) {
        try {
            return supplier.get();
        } catch (Exception e) {
            if (isExpectedException(e, expectedExceptions)) {
                System.out.println(e.getMessage());
                return execute(supplier, expectedExceptions);
            }
            throw e;
        }
    }

    private static boolean isExpectedException(Exception e, Class<? extends Exception>[] exceptionClasses) {
        for (Class<? extends Exception> exceptionClass : exceptionClasses) {
            if (exceptionClass.isInstance(e)) {
                return true;
            }
        }
        return false;
    }
}
