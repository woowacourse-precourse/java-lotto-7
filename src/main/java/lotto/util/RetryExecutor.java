package lotto.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RetryExecutor {
    private RetryExecutor() {
    }

    /**
     * 작업을 실행하고 지정된 예외 발생 시 재시도합니다. 재시도 시 발생한 예외는 제공된 콜백을 통해 처리됩니다.
     *
     * @param operation       실행할 작업
     * @param errorCallback   예외 발생 시 실행될 콜백
     * @param retryableErrors 재시도할 예외 목록
     * @param <T>             작업 결과의 타입
     * @return 작업 수행 결과
     */
    @SafeVarargs
    public static <T> T execute(
            Supplier<T> operation,
            Consumer<Exception> errorCallback,
            Class<? extends Exception>... retryableErrors
    ) {
        while (true) {
            try {
                return operation.get();
            } catch (Exception error) {
                if (isNotRetryableException(error, retryableErrors)) {
                    throw error;
                }

                errorCallback.accept(error);
            }
        }
    }

    /**
     * 작업을 실행하고 지정된 예외 발생 시 재시도합니다.
     *
     * @param operation       실행할 작업
     * @param retryableErrors 재시도할 예외 목록
     * @param <T>             작업 결과의 타입
     * @return 작업 수행 결과
     */
    @SafeVarargs
    public static <T> T execute(
            Supplier<T> operation,
            Class<? extends Exception>... retryableErrors
    ) {
        return execute(operation, error -> {
        }, retryableErrors);
    }

    private static boolean isNotRetryableException(
            Exception error,
            Class<? extends Exception>[] retryableErrors
    ) {
        for (Class<? extends Exception> retryableError : retryableErrors) {
            if (retryableError.isInstance(error)) {
                return false;
            }
        }

        return true;
    }
}
