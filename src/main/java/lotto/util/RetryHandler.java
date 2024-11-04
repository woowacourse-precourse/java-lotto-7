package lotto.util;

public class RetryHandler {

    private RetryHandler() {
    }

    public static <T> T retryIfError(SupplierWithException<T> method) {
        while (true) {
            try {
                return method.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
