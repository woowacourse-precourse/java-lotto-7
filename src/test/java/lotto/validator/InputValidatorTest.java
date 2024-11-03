package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private InputValidator validator;

    @Test
    void validateInputIsBlankTest() {
        String blank = " ";
        validator = new InputValidator(blank);

        assertThatThrownBy(validator::validate)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void validateInputIsNumberTest() {
    }
}