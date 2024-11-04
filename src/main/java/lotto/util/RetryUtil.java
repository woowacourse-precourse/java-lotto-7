package lotto.util;

import lotto.error.ErrorMessage;

public class RetryUtil {

    private static final int UNLIMITED_RETRIES = -1;  // 무한 재시도를 의미하는 상수

    private RetryUtil() {
        // 유틸리티 클래스는 상태를 가지지 않으므로 인스턴스 생성을 할 필요가 없다.
        // 모든 메서드는 static으로 선언되어 있으므로 인스턴스 생성 없이 사용 가능하다.
    }

    // 최대 실행 횟수를 지정하지 않은 경우 무한 재시도
    public static <T> T retryOnError(SupplierWithException<T> supplier) {
        return retryOnError(supplier, UNLIMITED_RETRIES);
    }

    // 최대 실행 횟수를 매개변수로 받는 경우
    public static <T> T retryOnError(SupplierWithException<T> supplier, int maxRetries) {
        int attempts = 0;

        while (shouldRetry(attempts, maxRetries)) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                attempts++;
                System.out.println(e.getMessage());
            }
        }

        throw new IllegalArgumentException(ErrorMessage.EXCEEDED_MAXIMUM_RETRY_ATTEMPTS.getMessage());
    }

    private static boolean shouldRetry(int attempts, int maxRetries) {
        return maxRetries == UNLIMITED_RETRIES || attempts < maxRetries;
    }
}
