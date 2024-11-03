package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @Test
    void 금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
