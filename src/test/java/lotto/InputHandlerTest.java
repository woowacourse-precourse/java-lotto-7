package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {
    @DisplayName("로또 구입 금액이 0원 이하일 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_0원_이하일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputHandler.validateLottoBudget(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputHandler.validateLottoBudget(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1_000으로_나누어_떨어지지_않을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputHandler.validateLottoBudget(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputHandler.validateLottoBudget(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputHandler.validateLottoBudget(1_001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
