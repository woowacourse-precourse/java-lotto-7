package lotto;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void testValidatePurchaseAmount_ValidInput() {
        int result = validator.validatePurchaseAmount("5000");
        assertEquals(5, result);
    }

    @Test
    void testValidatePurchaseAmount_InvalidAmount_Negative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmount("-1000");
        });
        assertEquals("[ERROR] 구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidatePurchaseAmount_InvalidAmount_NotMultipleOf1000() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmount("2500");
        });
        assertEquals("[ERROR] 구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidatePurchaseAmount_InvalidInput_NonNumeric() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmount("abcd");
        });
        assertEquals("[ERROR] 구입 금액은 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidatePurchaseAmount_InvalidAmount_Zero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmount("0");
        });
        assertEquals("[ERROR] 구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }
}
