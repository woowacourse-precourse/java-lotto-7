package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
