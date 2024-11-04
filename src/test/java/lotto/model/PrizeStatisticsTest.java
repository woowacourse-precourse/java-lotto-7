package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeStatisticsTest {

    @Test
    @DisplayName("PrizeStatistics 객체를 생성할 수 있다")
    public void 등수_통계_생성() {
        // given
        PrizeStatistics prizeStatistics = PrizeStatistics.createPrizeStatistics();

        // when
        Map<PrizeRank, Integer> statistics = prizeStatistics.getStatistics();

        // then
        assertThat(statistics).hasSize(PrizeRank.values().length);
        for (PrizeRank rank : PrizeRank.values()) {
            assertThat(statistics.get(rank)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("등수를 추가하면 해당 통계가 증가한다")
    public void addStatistic() {
        // given
        PrizeStatistics prizeStatistics = PrizeStatistics.createPrizeStatistics();
        PrizeRank rankToAdd = PrizeRank.FIRST;

        // when
        prizeStatistics.addStatistic(rankToAdd);
        prizeStatistics.addStatistic(rankToAdd);

        // then
        Map<PrizeRank, Integer> statistics = prizeStatistics.getStatistics();
        assertThat(statistics.get(rankToAdd)).isEqualTo(2);
    }
}
