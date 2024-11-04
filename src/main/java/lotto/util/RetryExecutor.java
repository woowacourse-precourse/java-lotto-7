package lotto.util;

import java.util.Arrays;
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
     * @throws Exception 재시도 불가능한 예외 발생 시
     */
    @SafeVarargs
    public static <T> T execute(
            Supplier<T> operation,
            Consumer<Exception> errorCallback,
            Class<? extends Exception>... retryableErrors
    ) throws Exception {
        while (true) {
            try {
                return operation.get();
            } catch (Exception error) {
                handleException(error, errorCallback, retryableErrors);
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
     * @throws Exception 재시도 불가능한 예외 발생 시
     */
    @SafeVarargs
    public static <T> T execute(
            Supplier<T> operation,
            Class<? extends Exception>... retryableErrors
    ) throws Exception {
        return execute(operation, error -> {
        }, retryableErrors);
    }

    private static void handleException(
            Exception error,
            Consumer<Exception> errorCallback,
            Class<? extends Exception>[] retryableErrors
    ) throws Exception {
        if (shouldRethrowException(error, retryableErrors)) {
            throw error;
        }

        errorCallback.accept(error);
    }

    private static boolean shouldRethrowException(
            Exception error,
            Class<? extends Exception>[] retryableErrors
    ) {
        return Arrays.stream(retryableErrors)
                .noneMatch(errorClass -> errorClass.isInstance(error));
    }
}
