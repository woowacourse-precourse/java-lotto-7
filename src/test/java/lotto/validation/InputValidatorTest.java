package lotto.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 유효한_입력_테스트() {
        assertDoesNotThrow(() ->
                InputValidator.validateNotEmpty("유효한 입력"));
    }

    @Test
    void null_입력_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NOT_EMPTY.getMessage());
    }

    @Test
    void 빈_값_입력_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NOT_EMPTY.getMessage());
    }

    @Test
    void 공백_입력_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NOT_EMPTY.getMessage());
    }
}