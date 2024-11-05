package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorCode;
import org.junit.jupiter.api.Test;

class CommonExceptionTest {

    @Test
    void CommonException_생성_및_메시지_확인() {
        ErrorCode errorCode = ErrorCode.INVALID_PURCHASE_AMOUNT;

        assertThatThrownBy(() -> {
            throw new CommonException(errorCode);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] " + errorCode.getMessage());
    }
}
