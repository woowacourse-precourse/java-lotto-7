package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("등수 반환")
    void of() {
        assertSimpleTest(() -> {
            Rank rank = Rank.of(6, false);
            assertThat(rank).isEqualTo(Rank.FIRST);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(5, true);
            assertThat(rank).isEqualTo(Rank.SECOND);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(5, false);
            assertThat(rank).isEqualTo(Rank.THIRD);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(4, false);
            assertThat(rank).isEqualTo(Rank.FOURTH);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(3, false);
            assertThat(rank).isEqualTo(Rank.FIFTH);
        });
    }

    @Test
    @DisplayName("등수별 당첨 개수 반환")
    void groupByRankWithCount() {
        assertSimpleTest(() -> {
            List<Rank> ranks = List.of(Rank.FIFTH, Rank.MISS, Rank.FIFTH, Rank.FOURTH, Rank.FIRST);
            Map<Rank, Long> groupByRankWithCount = Rank.groupByRankWithCount(ranks);

            assertThat(groupByRankWithCount.get(Rank.MISS)).isEqualTo(1);
            assertThat(groupByRankWithCount.get(Rank.FIFTH)).isEqualTo(2);
            assertThat(groupByRankWithCount.get(Rank.FOURTH)).isEqualTo(1);
            assertThat(groupByRankWithCount.get(Rank.THIRD)).isEqualTo(null);
            assertThat(groupByRankWithCount.get(Rank.SECOND)).isEqualTo(null);
            assertThat(groupByRankWithCount.get(Rank.FIRST)).isEqualTo(1);
        });
    }

    @Test
    @DisplayName("당첨금 반환")
    void calcTotalPrize() {
        assertSimpleTest(() -> {
            List<Rank> ranks = List.of(Rank.FIFTH, Rank.MISS, Rank.FIFTH, Rank.FOURTH, Rank.FIRST);
            long prizeSum = Rank.calcTotalPrize(ranks);
            assertThat(prizeSum).isEqualTo(5000 + 0 + 5000 + 50000 + 2000000000);
        });
    }
}
