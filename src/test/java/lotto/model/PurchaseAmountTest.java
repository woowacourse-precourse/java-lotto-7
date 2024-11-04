package lotto.model;

import static lotto.common.exception.ErrorMessage.PURCHASE_AMOUNT_VALUE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외_처리한다() {
        // given
        int amount = 2500;

        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_VALUE_ERROR.message());
    }

    @Test
    void 로또_구입_가능한_수량을_반환한다() {
        // given
        int amount = 5000;
        PurchaseAmount purchaseAmount = PurchaseAmount.from(amount);

        // when
        int purchaseQuantity = purchaseAmount.getPurchaseQuantity();

        // then
        assertEquals(purchaseQuantity, 5);
    }
}