package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 테스트")
public class WinningLottoTest {

    @Test
    void 당첨번호와_보너스번호로_당첨로또를_생성한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        //then
        assertThat(winningLotto.getWinningLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 당첨번호와_보너스번호가_중복되면_예외가_발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
