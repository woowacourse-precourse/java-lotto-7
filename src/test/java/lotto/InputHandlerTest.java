package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @DisplayName("당첨 번호의 숫자 범위가 올바르지 않을 때 예외가 발생한다.")
    @Test
    void 당첨_번호의_숫자_범위가_올바르지_않을_때_예외가_발생() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> InputHandler.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 숫자 6개여야 합니다.");
    }

    @DisplayName("당첨 번호의 숫자가 중복되는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_숫자가_중복될_때_예외가_발생() {
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> InputHandler.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 숫자 6개여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호 6개 중 중복이 있을 때 예외가 발생한다.")
    @Test
    void 보너스_번호와_당첨_번호가_중복될_때_예외가_발생() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThatThrownBy(() -> InputHandler.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않는 숫자여야 합니다.");
    }
}
