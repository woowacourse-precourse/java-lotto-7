package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class RetryHandlerTest {
    @Test
    @DisplayName("유효한 값을 반환할 때까지 재시도 성공")
    void testRetryUntilSuccessWithValidSupplier() {
        // given
        Supplier<String> validSupplier = () -> "Success";

        // when
        String result = RetryHandler.retryUntilSuccess(validSupplier);

        // then
        assertEquals("Success", result);
    }

    @Test
    @DisplayName("예외 발생 시 출력 메시지 확인")
    void testRetryUntilSuccessWithInvalidSupplier() {
        // given
        Supplier<String> invalidSupplier = () -> {
            throw new IllegalArgumentException("유효하지 않은 입력");
        };

        // when & then
        assertThrows(IllegalArgumentException.class, () -> RetryHandler.retryUntilSuccess(invalidSupplier), "유효하지 않은 입력");
    }
}