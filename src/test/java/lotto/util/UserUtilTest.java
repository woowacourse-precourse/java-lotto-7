package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserUtilTest {
    @Test
    void 구입금액_검증_테스트() {
        String inputPurchaseAmount = "10000";
        int expectedPurchaseAmount = 10000;

        int purchaseAmount = UserUtil.parseAndValidatePurchaseAmount(inputPurchaseAmount);

        assertEquals(expectedPurchaseAmount, purchaseAmount);
    }

    @Test
    void 구입금액_검증_예외() {
        String inputPurchaseAmount = "10000j";
        assertThrows(IllegalArgumentException.class, () ->
                UserUtil.parseAndValidatePurchaseAmount(inputPurchaseAmount)
        );
    }

}