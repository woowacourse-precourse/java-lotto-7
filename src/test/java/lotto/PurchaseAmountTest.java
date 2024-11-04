package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void 구입_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
