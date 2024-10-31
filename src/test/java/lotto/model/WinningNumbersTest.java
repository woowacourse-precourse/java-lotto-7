package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void 당첨번호와_보너스번호_정상_생성_테스트() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        WinningLotto winningNumbersobj = new WinningLotto(winningNumbers, bonusNumber);

        Assertions.assertThat(winningNumbersobj.getWinningNumbers().getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(winningNumbersobj.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    void 보너스번호가_범위를_벗어난_경우_예외처리() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 46;

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1 ~ 45사이의 당첨번호와 중복되지 않는 번호여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복된_경우_예외처리() {
        final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1 ~ 45사이의 당첨번호와 중복되지 않는 번호여야 합니다.");
    }
}