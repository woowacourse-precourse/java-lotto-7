package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("올바른 입력 값으로 WinningNumbers 객체가 정상적으로 생성된다.")
    @Test
    void 올바른_입력값으로_WinningNumbers_객체가_생성된다() {
        String input = "1,2,3,4,5,6";
        assertThatCode(() -> new WinningNumbers(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력 값이 6개의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 입력값이_6개의_숫자가_아니면_예외가_발생한다() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
    }

    @DisplayName("입력 값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 입력값이_숫자가_아닌_경우_예외가_발생한다() {
        String input = "1,2,three,4,5,6";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    @DisplayName("입력 값에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 입력값에_중복된_숫자가_있을_경우_예외가_발생한다() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
    }

    @DisplayName("입력 값에 1부터 45 사이가 아닌 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 입력값이_1부터_45_사이가_아닌_숫자가_있을_경우_예외가_발생한다() {
        String input = "1,2,3,4,5,46";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
