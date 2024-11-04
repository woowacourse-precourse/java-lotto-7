package lotto.week3.global.error.validate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @Test
    void testEmptyInput() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validate("")
        );
        assertEquals("[ERROR] 입력이 비어 있습니다. 금액을 입력해 주세요.", exception.getMessage());
    }

    @Test
    void testNonNumericInput() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validate("abcd")
        );
        assertEquals("[ERROR] 금액은 숫자로 입력해 주세요.", exception.getMessage());
    }

    @Test
    void testMinimumAmount() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validate("500")
        );
        assertEquals("[ERROR] 최소 구입 금액은 1,000원입니다.", exception.getMessage());
    }

    @Test
    void testThousandUnit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validate("1500")
        );
        assertEquals("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.", exception.getMessage());
    }

}