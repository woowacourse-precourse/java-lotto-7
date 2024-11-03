package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorCode;
import org.junit.jupiter.api.Test;

public class FormatExceptionTest {

    @Test
    void FormatException_생성_및_메시지_확인() {
        ErrorCode errorCode = ErrorCode.PARSING_INTEGER_ERROR;

        assertThatThrownBy(() -> {
            throw new FormatException(errorCode);
        }).isInstanceOf(NumberFormatException.class).hasMessage("[ERROR] " + errorCode.getMessage());
    }
}
