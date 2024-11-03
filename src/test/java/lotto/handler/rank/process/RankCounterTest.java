package lotto.handler.rank.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.handler.purchase.process.Lotto;
import lotto.handler.purchase.process.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankCounterTest {
    private RankCounter rankCounter;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void 구매_로또_리스트_당첨_번호_보너스_번호_초기화() {
        rankCounter = new RankCounter();
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8))
        );
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    @DisplayName("로또 당첨 등수별 개수가 정확히 계산되어야 한다.")
    void 로또_당첨_등수는_각_1등_1개_2등_1개_4등_1개_이다() {
        HashMap<WinningRank, Integer> rankCounts = rankCounter.countRanks(lottos, winningNumbers, bonusNumber);

        Map<WinningRank, Integer> expectedRankCounts = Map.of(
                WinningRank.FIRST, 1,
                WinningRank.SECOND, 1,
                WinningRank.FOURTH, 1,
                WinningRank.THIRD, 0,
                WinningRank.FIFTH, 0
        );

        expectedRankCounts.forEach((winningRank, expectedCount) ->
                assertEquals(expectedCount, rankCounts.getOrDefault(winningRank, expectedCount)));
    }
}