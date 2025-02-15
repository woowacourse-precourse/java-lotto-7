package lotto.utils;

import java.util.function.Supplier;

public class Retry {
    public static <T> T retryOnException(Supplier<T> operation) {
        while (true) { // 무한 루프를 사용하여 재시도
            try {
                return operation.get(); // 작업 실행
            } catch (IllegalArgumentException exception) {
                // 에러 메시지 출력
                System.out.println("[ERROR] " + exception.getMessage());
                // 재시도
            }
        }
    }
}
