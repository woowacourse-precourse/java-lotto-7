package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @Test
    @DisplayName("6개 일치하면 1등(FIRST)을 반환한다.")
    void 번호가_6개가_일치하면_1등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto( 7,List.of(1, 2, 3, 4, 5, 6));

        Prize prize = Prize.inspect(winningLotto, lotto);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하면 2등(SECOND)을 반환한다.")
    void 번호가_5개가_일치하고_보너스번호가_포함되면_2등이다() {
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Prize prize = Prize.inspect(winningLotto, lotto);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하지 않으면 3등(THIRD)을 반환한다.")
    void 번호가_5개가_일치하면_3등이다() {
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        Prize prize = Prize.inspect(winningLotto, lotto);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("4개 일치하면 4등(FOURTH)을 반환한다.")
    void 번호가_4개가_일치하면_4등이다() {
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        Prize prize = Prize.inspect(winningLotto, lotto);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    @DisplayName("3개 일치하면 5등(FIFTH)을 반환한다.")
    void 번호가_3개가_일치하면_5등이다() {
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        Prize prize = Prize.inspect(winningLotto, lotto);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    @DisplayName("2개 이하로 일치하면 MISS_MATCH를 반환한다.")
    void 번호가_2개_이하로_일치하면_2등이다() {
        WinningLotto winningLotto = new WinningLotto(7, List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        Prize prize = Prize.inspect(winningLotto, lotto);
        assertThat(prize).isEqualTo(Prize.MISS_MATCH);
    }
}
