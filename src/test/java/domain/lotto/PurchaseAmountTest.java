package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @Test
    void PurchaseAmount_생성() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount("1000"));
    }

    @Test
    void 구매금액이_숫자로_입력되지_않으면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    void 구매금액이_1000원으로_나누어_떨어지지_않으면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNDIVIDED_THOUSAND);
    }

    @Test
    void 구매_개수_계산() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");

        assertThat(purchaseAmount.calculatePurchaseCount()).isEqualTo(3);
    }

    @Test
    void 수익_비율_계산() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");

        assertThat(purchaseAmount.revenueRatio(5000)).isEqualTo(5.0);
    }
}
