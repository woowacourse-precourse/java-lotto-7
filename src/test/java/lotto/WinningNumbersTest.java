package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 6;
        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void 보너스_번호가_1_45_범위를_벗어나면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int invalidBonusLow = 0;
        int invalidBonusHigh = 46;

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, invalidBonusLow))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, invalidBonusHigh))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("올바른 당첨 번호와 보너스 번호로 WinningNumbers가 생성된다.")
    void 올바른_당첨_번호와_보너스_번호로_WinningNumbers가_생성된다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);
        assertThat(winningNumbers.getLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumbers.getBonus()).isEqualTo(7);
    }
}