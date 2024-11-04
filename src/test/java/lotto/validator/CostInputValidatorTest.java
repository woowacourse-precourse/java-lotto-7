package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CostInputValidatorTest {

    private final CostInputValidator validator = new CostInputValidator();

    @Test
    @DisplayName("유효한 정수 입력 시 예외가 발생하지 않음")
    void testValidIntegerInput() {
        assertDoesNotThrow(() -> validator.validate("1000"));
        assertDoesNotThrow(() -> validator.validate("2147483647")); // int의 최대값
        assertDoesNotThrow(() -> validator.validate("-2147483648")); // int의 최소값
    }

    @Test
    @DisplayName("유효하지 않은 입력 시 예외 발생 - 정수가 아닌 값")
    void testInvalidNonIntegerInput() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1000.5"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1000abc"));
    }

    @Test
    @DisplayName("입력이 int 범위를 벗어날 경우 예외 발생")
    void testOutOfIntRangeInput() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("2147483648")); // int 최대값 + 1
        assertThrows(IllegalArgumentException.class, () -> validator.validate("-2147483649")); // int 최소값 - 1
    }
}
