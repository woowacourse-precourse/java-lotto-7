package lotto.model.rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankResultTest {

    @Test
    @DisplayName("등급의 수를 추가할 수 있다.")
    void shouldIncrementRankCount() {
        RankResult rankResult = new RankResult();
        rankResult.addRank(Rank.FIFTH);
        rankResult.addRank(Rank.FOURTH);
        rankResult.addRank(Rank.FIFTH);

        assertEquals(2, rankResult.getRankCounts().get(Rank.FIFTH));
        assertEquals(1, rankResult.getRankCounts().get(Rank.FOURTH));
    }

    @Test
    @DisplayName("각 등급의 수는 불변하다.")
    void shouldBeImmutableRankCount() {
        RankResult rankResult = new RankResult();
        rankResult.addRank(Rank.FIFTH);

        assertThrows(UnsupportedOperationException.class, () -> {
            rankResult.getRankCounts().put(Rank.FOURTH, 1);
        });
    }

}
