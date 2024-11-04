package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    void 구매_가격이_1000원보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가격이_1000원으로_나누어_떨어지지_않는다면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
