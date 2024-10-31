package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("공백이 입력되면 예외를 발생한다.")
    @ValueSource(strings = {"", "   "})
    void inputEmptyExceptionTest(String input) {
        InputValidator validator = new InputValidator();

        Assertions.assertThatThrownBy(() -> validator.validator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}