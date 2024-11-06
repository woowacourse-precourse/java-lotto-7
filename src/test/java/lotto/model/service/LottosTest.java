package lotto.model.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.domain.BonusBall;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 6개를 산다")
    @Test
    void test1() {
        Lottos lottos = Lottos.from(6L, () -> List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, lottos.getSize());
    }

    //테스트를 위해 lotto의 생성자 private -> public
    @DisplayName("로또들의 일치결과를 알려준다.")
    @Test
    void test2() {
        Lottos lottos = Lottos.from(1L, () -> List.of(1, 2, 3, 4, 5, 7));
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = BonusBall.of(7, winningBalls);

        RankResult rankResult = lottos.calculateWinningResults(winningBalls, bonusBall);

        assertEquals(1, rankResult.getRankReuslts().get(Rank.SECOND));
    }
}
