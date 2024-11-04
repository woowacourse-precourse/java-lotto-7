package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;
import lotto.model.domain.BonusBall;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankResultTest {

    @DisplayName("객체를 올바르게 생성한다")
    @Test
    void test1() {
        RankResult rankResult = new RankResult();
        assertEquals(0, rankResult.getRankReuslts().get(Rank.FIFTH));
    }

    @DisplayName("출력을 올바르게 한다")
    @Test
    void test2() {
        RankResult rankResult = new RankResult();

        rankResult.increaseRankCount(Rank.FIFTH);

        assertThat(rankResult.toString()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @DisplayName("이천원 로또를 사고 당첨금 오천원의 수익률을 반환한다")
    @Test
    void test3() {
        Iterator<List<Integer>> numbers = List.of(
                List.of(8, 9, 10, 11, 12, 13),
                List.of(1, 2, 3, 43, 44, 45)
        ).iterator();

        Lottos lottos = Lottos.from(2L, numbers::next);
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = BonusBall.of(7, winningBalls);
        RankResult rankResult = lottos.calculateWinningResults(winningBalls, bonusBall);
        Long totalPrice = lottos.getTotalPrice();

        Float returnRate = rankResult.calculateReturnRate(totalPrice);

        assertEquals(250F, returnRate);
    }
}
