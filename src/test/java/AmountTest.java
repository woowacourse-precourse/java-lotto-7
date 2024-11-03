import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    void 금액이_1000으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Amount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Amount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
