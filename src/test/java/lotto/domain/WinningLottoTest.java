package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 증복된_번호가_존재하면_예외가_발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(1);

        //when //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 존재합니다.");
    }

    @Test
    void 로또의_랭크를_계산한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);

        //when
        Ranking ranking = winningLotto.calculateRanking(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        //then
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
}