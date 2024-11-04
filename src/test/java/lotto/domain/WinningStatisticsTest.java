package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.model.Ranking;
import lotto.model.WinningStatistics;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    void testCalculateROI() {
        List<Ranking> rankings = List.of(Ranking.FIFTH, Ranking.NONE, Ranking.NONE, Ranking.NONE, Ranking.NONE,
                Ranking.NONE, Ranking.NONE);
        int investmentCost = 8000;

        WinningStatistics statistics = new WinningStatistics(rankings, investmentCost);

        BigDecimal expectedRoi = BigDecimal.valueOf(62.5);
        assertThat(statistics.getRoi()).isEqualTo(expectedRoi);
    }

    @Test
    void testRankingCount() {
        List<Ranking> rankings = List.of(Ranking.FIRST, Ranking.FIRST, Ranking.THIRD, Ranking.NONE);

        WinningStatistics statistics = new WinningStatistics(rankings, 4000);

        Map<Ranking, Integer> expectedCounter = Map.of(
                Ranking.FIRST, 2,
                Ranking.THIRD, 1,
                Ranking.NONE, 1
        );
        assertThat(statistics.getCounter())
                .isEqualTo(expectedCounter);
    }
}
