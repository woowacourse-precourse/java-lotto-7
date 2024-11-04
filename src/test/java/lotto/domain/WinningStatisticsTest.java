package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.config.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics();
    }

    @Test
    void 초기화시_모든_등수의_당첨_횟수는_0() {
        for (LottoRank rank : LottoRank.values()) {
            assertThat(winningStatistics.getRankCount(rank)).isZero();
        }
    }

    @Test
    void 당첨_결과_추가시_해당_등수_카운트_증가() {
        MatchResult result = new MatchResult(6, false);
        winningStatistics.putRankCount(result);
        assertThat(winningStatistics.getRankCount(result.getRank())).isEqualTo(1);
    }

    @Test
    void 수익률_정확하게_계산() {
        MatchResult result = new MatchResult(6, false);
        winningStatistics.putRankCount(result);
        int purchaseAmount = 1000;
        double profitRate = winningStatistics.calculateProfitRate(purchaseAmount);
        double expectedRate = (double) result.getRank().getPrize() / purchaseAmount * 100;
        assertThat(profitRate).isEqualTo(expectedRate);
    }
}
