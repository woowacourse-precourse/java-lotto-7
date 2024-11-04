package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InvalidLottoExceptionTest {
    @Test
    void 커스텀_Exception_확인() {
        ExceptionMessage message = ExceptionMessage.ERROR_DUPLICATE_NUMBER;
        assertThatThrownBy(() -> {
            throw new InvalidLottoException(message);
        }).isInstanceOf(InvalidLottoException.class)
                .hasMessage(message.getMessage());
    }
}
