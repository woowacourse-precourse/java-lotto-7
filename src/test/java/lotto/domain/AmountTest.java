package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {
    @DisplayName("금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 금액이_1000으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Amount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 음수이면 예외가 발생한다.")
    @Test
    void 금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Amount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
