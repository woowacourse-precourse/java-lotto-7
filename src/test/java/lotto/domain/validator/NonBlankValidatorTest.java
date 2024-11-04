package lotto.domain.validator;

import static lotto.common.constant.ErrorMessages.BLANK_NOT_ALLOWED;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NonBlankValidatorTest {
    private NonBlankValidator validator;

    @BeforeEach
    void setUp() {
        validator = new NonBlankValidator();
    }

    @Test
    @DisplayName("정상적인 입력값은 검증을 통과한다")
    void validateShouldPassWithValidInput() {
        String input = "valid input";

        assertThatCode(() -> validator.validate(input))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("null 입력값은 예외가 발생한다")
    void validateShouldThrowExceptionForNull() {
        String input = null;

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(BLANK_NOT_ALLOWED.toString());
    }

    @Test
    @DisplayName("빈 문자열은 예외가 발생한다")
    void validateShouldThrowExceptionForEmptyString() {
        String input = "";

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(BLANK_NOT_ALLOWED.toString());
    }

    @Test
    @DisplayName("공백 문자열은 예외가 발생한다")
    void validateShouldThrowExceptionForBlankString() {
        String input = "   ";

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(BLANK_NOT_ALLOWED.toString());
    }
}
