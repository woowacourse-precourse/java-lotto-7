package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

class LottoResultCalculatorTest {

    @DisplayName("6개 번호가 일치하면 1등이다.")
    @Test
    void 번호6개_일치하면_1등() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        Rank rank = LottoResultCalculator.getRank(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이다.")
    @Test
    void 번호5개_보너스번호_일치하면_2등() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        Rank rank = LottoResultCalculator.getRank(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호가 일치하면 3등이다.")
    @Test
    void 번호5개_일치하면_3등() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        Rank rank = LottoResultCalculator.getRank(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 번호가 일치하면 4등이다.")
    @Test
    void 번호4개_일치하면_4등() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 9;

        // when
        Rank rank = LottoResultCalculator.getRank(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등이다.")
    @Test
    void 번호3개_일치하면_5등() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        // when
        Rank rank = LottoResultCalculator.getRank(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하로 번호가 일치하면 낙첨이다.")
    @Test
    void 번호2개_이하_일치하면_낙첨() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10));
        Lotto winningLotto = new Lotto(Arrays.asList(3, 4, 5, 6, 11, 12));
        int bonusNumber = 13;

        // when
        Rank rank = LottoResultCalculator.getRank(lotto, winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
