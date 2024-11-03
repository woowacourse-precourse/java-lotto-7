package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @DisplayName("구입 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine().buy(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoMachine().buy(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}