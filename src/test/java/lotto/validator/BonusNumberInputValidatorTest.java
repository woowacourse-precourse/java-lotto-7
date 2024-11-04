package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberInputValidatorTest {

    private final BonusNumberInputValidator validator = new BonusNumberInputValidator();

    @Test
    @DisplayName("유효한 정수 입력 시 예외가 발생하지 않음")
    void testValidIntegerInput() {
        assertDoesNotThrow(() -> validator.validate("42"));
    }

    @Test
    @DisplayName("유효하지 않은 입력 시 예외 발생 - 정수가 아닌 값")
    void testInvalidNonIntegerInput() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("42.5"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("42abc"));
    }
}
