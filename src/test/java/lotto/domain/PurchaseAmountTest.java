package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private static final String CAN_BUY_SEVEN = "7000";
    private static final String NOT_DIVIDE_UP = "1234";
    private static final String NOT_POSSIBLE_RANGE = "2147483649";
    private static final String NEGATIVE = "-1";

    @Test
    void 구입금액에_알맞은_로또_개수가_나오는지_테스트_한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(CAN_BUY_SEVEN);
        Assertions.assertThat(purchaseAmount.getCanBuyLottoCount()).isEqualTo(7);
    }

    @Test
    void 구입금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(NOT_DIVIDE_UP))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_int_범위를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(NOT_POSSIBLE_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액에_양수가_아닌_값이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(NEGATIVE))
                .isInstanceOf(IllegalArgumentException.class);
    }

}