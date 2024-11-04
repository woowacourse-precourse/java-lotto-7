package lotto.util;

import org.junit.jupiter.api.Test;

import static lotto.util.ValidationUtils.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {
    @Test
    public void testValidateNotEmpty_ValidInput() {
        assertDoesNotThrow(() -> validateNotEmpty("1000"));
    }

    @Test
    public void testValidateNotEmpty_EmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> validateNotEmpty(""));
    }

    @Test
    public void testValidateIsNumber_ValidNumber() {
        assertDoesNotThrow(() -> validateIsNumber("1000"));
    }

    @Test
    public void testValidateIsNumber_InvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> validateIsNumber("abc"));
    }

    @Test
    public void testValidatePositive_PositiveValue() {
        assertDoesNotThrow(() -> validatePositive(1000));
    }

    @Test
    public void testValidatePositive_ZeroValue() {
        assertThrows(IllegalArgumentException.class, () -> validatePositive(0));
    }

    @Test
    public void testValidatePositive_NegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> validatePositive(-1000));
    }

    @Test
    public void testValidateThousandUnit_ValidUnit() {
        assertDoesNotThrow(() -> validateThousandUnit(1000));
    }

    @Test
    public void testValidateThousandUnit_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> validateThousandUnit(1500));
    }

    @Test
    public void testParseLong_InputExceedsLongMaxValue() {
        // 아주 큰 숫자 (long 범위를 초과하는 값)
        String largeNumber = "9223372036854775808"; // Long.MAX_VALUE + 1

        assertThrows(NumberFormatException.class, () -> Long.parseLong(largeNumber));
    }
}
