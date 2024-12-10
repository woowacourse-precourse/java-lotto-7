package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessages;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void 유효한_구매금액으로_객체_생성_성공() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
        assertThat(purchaseAmount.getTicketCount()).isEqualTo(5);
    }

    @Test
    void 구매금액이_null일_경우_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NULL_PURCHASE_AMOUNT);
    }

    @Test
    void 구매금액이_숫자가_아닐_경우_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_PURCHASE_AMOUNT_INPUT_ERROR);
    }

    @Test
    void 구매금액이_0_이하이거나_1000원단위가_아닌_경우_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT);

        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT);
    }

    @Test
    void 구매금액이_최대구매금액을_초과할_경우_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount("150000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.EXCEEDED_PURCHASE_AMOUNT);
    }

    @Test
    void 수익률_계산_정상작동() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        String yield = purchaseAmount.calculateYield(3333);
        assertThat(yield).isEqualTo("111.1");

        purchaseAmount = new PurchaseAmount("3000");
        yield = purchaseAmount.calculateYield(3375);
        assertThat(yield).isEqualTo("112.5");
    }
}
