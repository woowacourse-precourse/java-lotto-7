package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {
    @DisplayName("올바른 구매 금액이 입력되었을 때 구매금액 확인")
    @Test
    void 올바른_구매_금액이_입력되었을_때_구매금액_확인() {
        assertThat(InputHandler.getPurchaseAmount("5000")).isEqualTo(5000);
    }

    @DisplayName("올바르지 않은 구매 금액이 입력되었을 때 예외가 발생")
    @Test
    void 올바르지_않은_구매_금액이_입력되었을_때_예외가_발생() {
        assertThatThrownBy(() -> InputHandler.getPurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
}
