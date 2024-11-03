package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseValidatorTest {
    private final PurchaseValidator purchaseValidator = new PurchaseValidator();

    @Test
    @DisplayName("실패 - 구매 금액이 숫자가 아닌 값일 경우")
    void 구매_금액_검증_테스트_숫자가_아닌_경우() {
        assertFalse(purchaseValidator.validatePurchaseMoney("abcd"));
        assertFalse(purchaseValidator.validatePurchaseMoney("ab1000"));
    }

    @Test
    @DisplayName("실패 - 구매 금액이 공백이거나 빈 값일 경우")
    void 구매_금액_검증_테스트_공백_빈값() {
        assertFalse(purchaseValidator.validatePurchaseMoney(""));
        assertFalse(purchaseValidator.validatePurchaseMoney(" "));
    }

    @Test
    @DisplayName("실패 - 구매 금액이 1,000원 단위가 아닐 경우")
    void 구매_금액_검증_테스트_천원_단위() {
        assertFalse(purchaseValidator.validatePurchaseMoney("1700")); // 예시로 최소 금액이 1000이라 가정
        assertFalse(purchaseValidator.validatePurchaseMoney("0"));
        assertFalse(purchaseValidator.validatePurchaseMoney("-1700"));
    }

    @Test
    @DisplayName("성공 - 구매 금액 앞,뒤,사이에 공백이 있는경우")
    void 구매_금액_검증_테스트_올바른_값_사이_공백() {
        assertTrue(purchaseValidator.validatePurchaseMoney("1000"));
        assertTrue(purchaseValidator.validatePurchaseMoney("   1000"));
    }
}
