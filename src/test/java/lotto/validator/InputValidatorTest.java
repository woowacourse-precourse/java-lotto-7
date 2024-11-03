package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final InputValidator validator = new InputValidator();

    @Test
    void validateInputIsBlankTest() {
        String blank = " ";

        assertThatThrownBy(() -> validator.validateInputIsBlank(blank))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void validateInputIsNumberTest() {
    }
}