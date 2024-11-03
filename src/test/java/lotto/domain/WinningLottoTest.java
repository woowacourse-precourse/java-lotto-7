package lotto.domain;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    void WinningLottoBonusNumberIsDuplicated_Execption() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또가 정상적으로 생성된다.")
    void WinningLottoBonusNumberIsNotDuplicated_Success() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        WinningLotto result = new WinningLotto(winningNumbers, bonusNumber);

        // then
        assertThat(result.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(result.getBonusNumber()).isEqualTo(bonusNumber);

        assertThat(result.getWinningNumbers().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(result.getBonusNumber()).isNotIn(result.getWinningNumbers().getNumbers());
    }
}
