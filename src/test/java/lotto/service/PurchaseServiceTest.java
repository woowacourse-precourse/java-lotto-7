package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseServiceTest {
    private static final PurchaseService purchaseService = new PurchaseService();

    @Test
    @DisplayName("구입한 금액만큼의 로또의 개수를 반환한다.")
    void calculateLottoCountByPurchaseAmount () {
        // given
        String rawPurchaseAmount = VALID_PURCHASE_AMOUNT;

        // when
        Integer purchaseAmount = purchaseService.purchaseLotto(rawPurchaseAmount);

        // then
        assertEquals(PURCHASE_AMOUNT, purchaseAmount);
    }
}