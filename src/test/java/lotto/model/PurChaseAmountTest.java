package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.Test;

class PurChaseAmountTest {

    @Test
    void 올바른_구매금액을_입력한다면_정상_동작() {
        // given
        String input = "5000";

        // when
        PurchaseAmount purChaseAmount = PurchaseAmount.from(input);

        // then
        assertThat(purChaseAmount.getAmount()).isEqualTo(5000);
    }

    @Test
    void 최소_금액보다_적게_구매했을_때_예외_발생() {
        // given
        String input = String.valueOf(PurchaseAmount.MIN_PURCHASE_AMOUNT - 1);
        
        // when
        // then
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.MIN_AMOUNT.formatMessage(PurchaseAmount.MIN_PURCHASE_AMOUNT));
    }

    @Test
    void 최대_금액보다_많게_구매했을_때_예외_발생() {
        // given
        String input = String.valueOf(PurchaseAmount.MAX_PURCHASE_AMOUNT + 1);

        // when
        // then
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.MAX_AMOUNT.formatMessage(PurchaseAmount.MAX_PURCHASE_AMOUNT));
    }

    @Test
    void 설정된_단위로_구매하지_않는다면_예외_발생() {
        // given
        String input = String.valueOf(PurchaseAmount.PURCHASE_UNIT_AMOUNT + 1);

        // when
        // then
        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.UNIT_AMOUNT.formatMessage(PurchaseAmount.PURCHASE_UNIT_AMOUNT));
    }
}
