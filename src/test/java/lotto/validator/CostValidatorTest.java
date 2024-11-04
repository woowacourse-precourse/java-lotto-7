package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CostValidatorTest {

    private final CostValidator validator = new CostValidator();

    @Test
    @DisplayName("유효한 비용 입력 시 예외가 발생하지 않음")
    void testValidCost() {
        assertDoesNotThrow(() -> validator.validate(1000));
        assertDoesNotThrow(() -> validator.validate(5000));
        assertDoesNotThrow(() -> validator.validate(10000));
    }

    @Test
    @DisplayName("음수 비용 입력 시 예외 발생")
    void testNegativeCost() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(-1000));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(-1));
    }

    @Test
    @DisplayName("1000원 미만의 비용 입력 시 예외 발생")
    void testBelowMinimumCost() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(500));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(999));
    }

    @Test
    @DisplayName("1000원 단위가 아닌 비용 입력 시 예외 발생")
    void testNotDivisibleByThousand() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(1500));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(2500));
    }
}
