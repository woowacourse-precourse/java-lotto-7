package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("당첨 번호가 정상적으로 입력되면 예외가 발생하지 않는다.")
    @Test
    void 당첨_번호가_정상적으로_입력되면_예외가_발생하지_않는다() {
        InputHandler.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_1_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputHandler.validateWinningNumbers(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputHandler.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputHandler.validateWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputHandler.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정상적으로 입력되면 예외가 발생하지 않는다.")
    @Test
    void 보너스_번호가_정상적으로_입력되면_예외가_발생하지_않는다() {
        InputHandler.validateBonusNumber(7);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_1_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputHandler.validateBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputHandler.validateBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
