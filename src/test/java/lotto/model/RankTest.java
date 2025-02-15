package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    WinningLotto winningLotto;

    @BeforeEach
    void beforeEach() {
        Lotto winningNumberLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        winningLotto = new WinningLotto(winningNumberLotto, bonus);
    }

    @Test
    @DisplayName("로또 당첨 순위에 해당되지 않으면 IllegalStateException을 던진다.")
    void givenInvalidRank_whenFindRank_thenIllegalStateException() {
        Lotto purchasedLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        assertThatThrownBy(() -> Rank.findRank(winningLotto, purchasedLotto))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("올바른 등수가 계산되어 나온다.")
    void givenValidRank_whenFindRank_thenCorrect() {
        Lotto purchasedLotto = new Lotto(List.of(3, 4, 5, 6, 8, 9));
        Rank excepted = Rank.FORTH_PRIZE;
        Rank result = Rank.findRank(winningLotto, purchasedLotto);
        Assertions.assertEquals(excepted, result);
    }

}