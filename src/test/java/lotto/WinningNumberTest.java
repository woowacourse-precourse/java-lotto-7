package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("쉼표로 구분된 6개의 당첨 번호가 정상적으로 생성된다.")
    @Test
    void createWinningNumber() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");
        assertThat(winningNumber.getWinningLotto().getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void invalidWinningNumberSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 있는 경우 예외가 발생한다.")
    @Test
    void invalidWinningNumberFormat() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,a", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void duplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}