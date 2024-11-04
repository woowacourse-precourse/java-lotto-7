package lotto.domain;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.Map;
import lotto.common.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    private LottoStatistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new LottoStatistics();
    }

    @Test
    void testRecordResult() {
        statistics.recordResult(LottoRank.FIRST);
        statistics.recordResult(LottoRank.SECOND);
        statistics.recordResult(LottoRank.SECOND);
        statistics.recordResult(LottoRank.THIRD);
        statistics.recordResult(LottoRank.THIRD);
        statistics.recordResult(LottoRank.THIRD);

        Map<LottoRank, Integer> results = statistics.getResults();
        assertSoftly(softly -> {
            softly.assertThat(results.get(LottoRank.FIRST)).isEqualTo(1);
            softly.assertThat(results.get(LottoRank.SECOND)).isEqualTo(2);
            softly.assertThat(results.get(LottoRank.THIRD)).isEqualTo(3);
            softly.assertThat(results.get(LottoRank.FOURTH)).isEqualTo(0);
            softly.assertThat(results.get(LottoRank.FIFTH)).isEqualTo(0);
            softly.assertThat(results.get(LottoRank.NONE)).isEqualTo(0);
        });
    }

    @Test
    void testCalculateProfitRate() {
        int totalInvestment = 5000;

        statistics.recordResult(LottoRank.FIRST);
        statistics.recordResult(LottoRank.SECOND);
        statistics.recordResult(LottoRank.FOURTH);
        statistics.recordResult(LottoRank.FOURTH);

        double profitRate = statistics.calculateProfitRate(totalInvestment);
        assertSoftly(softly -> {
            softly.assertThat(profitRate).isGreaterThan(0);
            softly.assertThat(profitRate).isEqualTo((2_000_000_000 + 30_000_000 + 50_000 * 2) / 5000.0 * 100);
        });
    }

    @Test
    void testInitialResultsAreZero() {
        assertSoftly(softly -> {
            statistics.getResults().forEach((rank, count) ->
                    softly.assertThat(count).as("count: %s", rank).isEqualTo(0)
            );
        });
    }
}