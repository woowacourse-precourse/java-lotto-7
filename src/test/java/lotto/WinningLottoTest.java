package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("로또와 당첨 번호를 비교하여 Rank를 계산한다.")
    void 로또와_당첨번호를_비교하여_Rank를_계산한다() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = winningLotto.calculateRank(lotto);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
