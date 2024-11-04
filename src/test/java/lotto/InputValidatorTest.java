package lotto;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.Test;
import java.util.List;

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

    @Test
    void testValidateWinningNumbers_ValidInput() {
        List<Integer> result = validator.validateWinningNumbers("1,2,3,4,5,6");
        assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void testValidateWinningNumbers_ContainsNonNumeric() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateWinningNumbers("1,2,a,4,5,6");
        });
        assertEquals("[ERROR] 당첨 번호는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidateWinningNumbers_OutsideRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateWinningNumbers("0,2,3,4,5,46");
        });
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidateBonusNumber_ValidInput() {
        int result = validator.validateBonusNumber("7", List.of(1, 2, 3, 4, 5, 6));
        assertEquals(7, result);
    }

    @Test
    void testValidateBonusNumber_InvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBonusNumber("a", List.of(1, 2, 3, 4, 5, 6));
        });
        assertEquals("[ERROR] 보너스 번호는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidateBonusNumber_OutsideRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBonusNumber("0", List.of(1, 2, 3, 4, 5, 6));
        });
        assertEquals("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidateBonusNumber_DuplicateWithWinningNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBonusNumber("1", List.of(1, 2, 3, 4, 5, 6));
        });
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }
}

