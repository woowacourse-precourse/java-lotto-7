package lotto.view.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setUp() {
        purchaseAmount = new PurchaseAmount();
    }

    @Test
    @DisplayName("올바른 구매 금액 입력 시 정상 처리")
    void parseValidAmount() {
        assertEquals(1000, purchaseAmount.parseAndValidateAmountForTest("1000"));
        assertEquals(5000, purchaseAmount.parseAndValidateAmountForTest("5000"));
        assertEquals(10000, purchaseAmount.parseAndValidateAmountForTest("10000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "1500", "999", "1001"})
    @DisplayName("잘못된 구매 금액 입력 시 예외 발생")
    void parseInvalidAmount(String invalidAmount) {
        assertThrows(IllegalArgumentException.class,
            () -> purchaseAmount.parseAndValidateAmountForTest(invalidAmount));
    }

    @Test
    @DisplayName("숫자가 아닌 입력 시 예외 발생")
    void parseNonNumericAmount() {
        assertThrows(IllegalArgumentException.class,
            () -> purchaseAmount.parseAndValidateAmountForTest("abc"));
    }

    @Test
    @DisplayName("최대 정수 범위를 초과하는 입력 시 예외 발생")
    void parseOverflowAmount() {
        assertThrows(IllegalArgumentException.class,
            () -> purchaseAmount.parseAndValidateAmountForTest("10000000000000000000"));
    }
}