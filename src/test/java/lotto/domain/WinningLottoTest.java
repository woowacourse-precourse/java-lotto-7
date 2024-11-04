package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    void bonusNumberDuplicateWithWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외 발생")
    void bonusNumberOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 정상적으로 생성되는지 테스트")
    void winningLottoValid() {
        WinningLotto winningLotto = new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto.getWinningLotto().getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
