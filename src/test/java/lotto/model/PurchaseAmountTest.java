package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @Test
    @DisplayName("10000원을 구입했을 때 구매한 로또 수는 10개다")
    void createPurchaseAmount_withValidAmount() {
        int validAmount = 10000;

        PurchaseAmount purchaseAmount = new PurchaseAmount(validAmount);

        assertThat(purchaseAmount.getLottoCount()).isEqualTo(validAmount / PurchaseAmount.LOTTO_PRICE);
        assertThat(purchaseAmount.getAmount()).isEqualTo(validAmount);
    }
}
