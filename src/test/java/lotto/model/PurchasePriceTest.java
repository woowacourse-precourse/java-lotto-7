package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasePriceTest {
    @Test
    void 구입_금액이_1000으로_나누어_떨이지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchasePrice(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
