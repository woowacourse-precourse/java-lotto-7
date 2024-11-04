package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 당첨_번호와_보너스_번호_중복_예외() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(lotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_일치_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 7, 9, 10)), 12);
        assertThat(winningLotto.matchWinningNumber(lotto.getNumbers()))
                .isEqualTo(3);
    }

    void 보너스_번호_일치_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 7, 9, 10)), 12);
        assertThat(winningLotto.matchBonusNumber(lotto.getNumbers()))
                .isTrue();
    }
}