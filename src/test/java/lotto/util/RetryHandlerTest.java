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
}