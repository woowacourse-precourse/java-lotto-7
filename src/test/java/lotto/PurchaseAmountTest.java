package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    void 구입금액이_0원_이하면_예외가_발생한다() {
        // given
        long amount = -1;

        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_1000원_단위가_아니라면_예외가_발생한다() {
        // given
        long amount = 1500;

        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
