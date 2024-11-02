package lotto.model;

import static lotto.utils.Error.PURCHASE_AMOUNT_NOT_DIVISIBLE;
import static lotto.utils.Error.PURCHASE_AMOUNT_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DepositTest {
    @Test
    void 구매_금액이_1_000에서_1_000_000를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Deposit(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_OUT_OF_RANGE.getDescription());
    }

    @Test
    void 구매_금액이_1_000으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Deposit(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_DIVISIBLE.getDescription());
    }
}
