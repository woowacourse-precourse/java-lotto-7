package lotto.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void 로또_랭크_테스트() {
        assertEquals(6, Rank.FIRST.getMatchingCount());
        assertEquals(5, Rank.SECOND.getMatchingCount());
        assertEquals(5, Rank.THIRD.getMatchingCount());
        assertEquals(4, Rank.FOURTH.getMatchingCount());
        assertEquals(3, Rank.FIFTH.getMatchingCount());

        assertEquals(2000000000, Rank.FIRST.getPrize());
        assertEquals(30000000, Rank.SECOND.getPrize());
        assertEquals(1500000, Rank.THIRD.getPrize());
        assertEquals(50000, Rank.FOURTH.getPrize());
        assertEquals(5000, Rank.FIFTH.getPrize());
    }

    @Test
    void 랭크_결정_테스트() {
        assertEquals(Rank.FIRST, Rank.determineRank(6, false));
        assertEquals(Rank.SECOND, Rank.determineRank(5, true));
        assertEquals(Rank.THIRD, Rank.determineRank(5, false));
        assertEquals(Rank.FOURTH, Rank.determineRank(4, false));
        assertEquals(Rank.FIFTH, Rank.determineRank(3, false));
        assertEquals(Rank.NONE, Rank.determineRank(0, false));
    }
}
