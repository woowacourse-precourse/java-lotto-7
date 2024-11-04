package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.common.config.LottoRank;
import lotto.domain.MatchResult;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    private WinningResult winningResult;
    private List<MatchResult> results;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
        results = Arrays.asList(
                new MatchResult(6, false),
                new MatchResult(5, true),
                new MatchResult(5, false),
                new MatchResult(5, false)
        );
    }

    @Test
    void 당첨_결과_정상_처리() {
        winningResult.processMatchResults(results);
        WinningStatistics statistics = winningResult.getStatistics();
        assertThat(statistics.getRankCount(LottoRank.MATCH_6)).isEqualTo(1);
        assertThat(statistics.getRankCount(LottoRank.MATCH_5_BONUS)).isEqualTo(1);
        assertThat(statistics.getRankCount(LottoRank.MATCH_5)).isEqualTo(2);
    }

    @Test
    void 수익률_정확하게_계산() {
        winningResult.processMatchResults(results);
        int purchaseAmount = 5000;
        double profitRate = winningResult.getProfitRate(purchaseAmount);
        long expectedTotalPrize =
                LottoRank.MATCH_6.getPrize() + LottoRank.MATCH_5_BONUS.getPrize() + LottoRank.MATCH_5.getPrize() * 2;
        double expectedProfitRate = (double) expectedTotalPrize / purchaseAmount * 100;
        assertThat(profitRate).isGreaterThan(0);
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
