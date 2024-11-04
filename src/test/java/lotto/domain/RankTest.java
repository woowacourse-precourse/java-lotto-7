package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void RANK_상금이_일치_테스트() {
        assertEquals(2000000000, Rank.FIRST.getPrize());
        assertEquals(30000000, Rank.SECOND.getPrize());
        assertEquals(1500000, Rank.THIRD.getPrize());
        assertEquals(50000, Rank.FOURTH.getPrize());
        assertEquals(5000, Rank.FIFTH.getPrize());
        assertEquals(0, Rank.NONE.getPrize());
    }

    @Test
    void 맞춘_개수와_보너스에_따른_랭크_체크_테스트() {
        assertEquals(Rank.FIRST, Rank.getRank(6, false));
        assertEquals(Rank.SECOND, Rank.getRank(5, true));
        assertEquals(Rank.THIRD, Rank.getRank(5, false));
        assertEquals(Rank.FOURTH, Rank.getRank(4, false));
        assertEquals(Rank.FIFTH, Rank.getRank(3, false));
        assertEquals(Rank.NONE, Rank.getRank(2, false));
    }

    @Test
    void 상금이_문자열_테스트() {
        assertEquals("2,000,000,000", Rank.FIRST.getPrizeToString());
        assertEquals("30,000,000", Rank.SECOND.getPrizeToString());
        assertEquals("1,500,000", Rank.THIRD.getPrizeToString());
    }
}
