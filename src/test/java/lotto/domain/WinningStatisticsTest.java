package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("각 랭크별 당첨 횟수는 0으로 초기화한다.")
    @Test
    void 각_랭크_당첨_횟수_0_초기화() {
        WinningStatistics winningStatistics = new WinningStatistics();

        Set<WinningRank> winningRanks = winningStatistics.getStatistics().keySet();
        winningRanks.forEach(rank -> {
            assertEquals(0, winningStatistics.getStatistics().get(rank));
        });
    }

    @DisplayName("랭크별 당첨 횟수를 증가한다.")
    @Test
    void 랭크_당첨_횟수_증가() {
        WinningStatistics winningStatistics = new WinningStatistics();

        winningStatistics.incrementRankCount(WinningRank.FIRST);

        assertEquals(1, winningStatistics.getStatistics().get(WinningRank.FIRST));
    }
    
}