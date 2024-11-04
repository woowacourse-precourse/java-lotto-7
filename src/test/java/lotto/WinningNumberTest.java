package lotto;

import lotto.domain.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    @DisplayName("당첨 번호의 구분자를 잘못 입력하면 예외가 발생한다.")
    @Test
    void 당첨_번호의_구분자를_잘못_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberValidator.validate("1,2,3,4,5,,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberValidator.validate("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberValidator.validate("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호의 범위가 벗어나면 예외가 발생한다.")
    @Test
    void 당첨_번호의_범위가_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberValidator.validate("1,2,3,4,5,55"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호가 비어있는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_비어있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumberValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
