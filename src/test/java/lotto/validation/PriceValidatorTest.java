package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import enums.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceValidatorTest {

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void validateNull(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validatePrice(input);
        });

        assertEquals(ErrorMessage.INPUT_NULL.getErrorMessage(), exception.getMessage());
    }

    private long parseAndValidateInput(String input) {
        return Long.parseLong(input.trim());
    }

    @DisplayName("0을 입력한 경우 예외가 발생한다.")
    @Test
    void validateZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validatePrice("0");
        });

        assertEquals(ErrorMessage.INPUT_ZERO.getErrorMessage(), exception.getMessage());
    }
}