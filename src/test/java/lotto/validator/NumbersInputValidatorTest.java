package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersInputValidatorTest {

    private final NumbersInputValidator validator = new NumbersInputValidator();

    @Test
    @DisplayName("유효한 정수 목록 입력 시 예외가 발생하지 않음")
    void testValidIntegerList() {
        assertDoesNotThrow(() -> validator.validate("1,2,3,4,5,6"));
        assertDoesNotThrow(() -> validator.validate("10,20,30,40,50,60"));
    }

    @Test
    @DisplayName("쉼표로 구분되지 않은 입력 문자열 시 예외 발생")
    void testInvalidDelimiter() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1 2 3 4 5 6"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("123456"));
    }

    @Test
    @DisplayName("정수가 아닌 값이 포함된 입력 문자열 시 예외 발생")
    void testInvalidIntegerList() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1,a,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("10,20,abc,40,50,60"));
    }
}
