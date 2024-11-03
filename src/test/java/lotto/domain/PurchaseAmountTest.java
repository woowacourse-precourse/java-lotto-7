package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.TestConstants.*;
import static lotto.TestConstants.INVALID_LOTTO_PRICE_UNIT;
import static lotto.common.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위의 숫자면 PurchaseAmount가 잘 생성된다.")
    void purchaseAmountIsNumberWithValidPriceUnit () {
        // given
        String rawPurchaseAmount = VALID_PURCHASE_AMOUNT;

        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);

        // then
        Integer actualPurchaseAmount = Integer.parseInt(VALID_PURCHASE_AMOUNT);
        assertTrue(purchaseAmount.compareAmount(actualPurchaseAmount));
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 에러를 반환한다.")
    void purchaseAmountIsNotNumber () {
        // given
        String rawPurchaseAmount = INVALID_NUMBER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount(rawPurchaseAmount);
        });

        assertEquals(ERROR_PROMPT + INVALID_PRICE_UNIT, exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 2,147,483,000을 넘을 경우 에러를 반환한다.")
    void purchaseAmountIsUpperMax () {
        // given
        String rawPurchaseAmount = INVALID_PURCHASE_AMOUNT_RANGE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount(rawPurchaseAmount);
        });

        assertEquals(ERROR_PROMPT + UP_MAX_PURCHASE_AMOUNT, exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 에러를 반환한다.")
    void purchaseAmountIsInvalidPriceUnit () {
        // given
        String rawPurchaseAmount = INVALID_LOTTO_PRICE_UNIT;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount(rawPurchaseAmount);
        });

        assertEquals(ERROR_PROMPT + INVALID_PRICE_UNIT, exception.getMessage());
    }

}