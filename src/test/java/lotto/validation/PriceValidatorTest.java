package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import lotto.enums.ErrorMessage;
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

    @DisplayName("0을 입력한 경우 예외가 발생한다.")
    @Test
    void validateZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validatePrice("0");
        });

        assertEquals(ErrorMessage.INPUT_ZERO.getErrorMessage(), exception.getMessage());
    }

    @DisplayName("1000 미만의 값을 입력한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"944", "100"})
    void validateUnderThousand(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validatePrice(input);
        });

        assertEquals(ErrorMessage.PRICE_UNDER_THOUSAND.getErrorMessage(), exception.getMessage());
    }

    @DisplayName("입력한 값이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"14300", "1200"})
    void validateDivideThousand(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validatePrice(input);
        });

        assertEquals(ErrorMessage.PRICE_NOT_DIVIDE_THOUSAND.getErrorMessage(), exception.getMessage());
    }

    @DisplayName("입력한 값에 숫자 이외의 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "1200 "})
    void validateOnlyNumbers(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validatePrice(input);
        });

        assertEquals(ErrorMessage.NOT_ALLOW_WITHOUT_NUMBER.getErrorMessage(), exception.getMessage());
    }
}