package lotto.domain;

import lotto.exception.Money.DivideMoneyException;
import lotto.exception.Money.NegativeMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("금액이 음수면 NegativeMoneyException이 발생한다.")
    @Test
    void 금액이_음수면_예외발생() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(NegativeMoneyException.class)
                .hasMessageContaining("[ERROR] 금액은 양의 정수여야 합니다.");
    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 DivideMoneyException이 발생한다.")
    @Test
    void 금액이_1000원으로_나누어떨어지지_않으면_예외발생() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(DivideMoneyException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
}
