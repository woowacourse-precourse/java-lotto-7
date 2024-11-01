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
}