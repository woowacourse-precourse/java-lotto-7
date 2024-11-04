package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 비교하여 일치하는 번호의 개수를 반환한다.")
    void 당첨번호와_일치하는_개수를_반환한다() {
        // given
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        // when
        int matchCount = winningLotto.countMatches(lotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호가 일치하면 true를 반환한다.")
    void 보너스_번호가_일치하면_true가_반환된다() {
        // given
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(7, 2, 3, 8, 9, 10));

        // when
        boolean isBonusMatched = winningLotto.isMatchedBonus(lotto);

        // then
        assertThat(isBonusMatched).isTrue();
    }
}
