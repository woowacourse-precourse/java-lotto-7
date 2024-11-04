package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @Test
    void 일치_개수와_보너스_여부에_따른_Rank_확인_테스트() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.MISS, Rank.valueOf(2, false));
    }

    @Test
    void 상금_확인_테스트() {
        assertEquals(2_000_000_000, Rank.FIRST.getPrize());
        assertEquals(30_000_000, Rank.SECOND.getPrize());
        assertEquals(1_500_000, Rank.THIRD.getPrize());
        assertEquals(50_000, Rank.FOURTH.getPrize());
        assertEquals(5_000, Rank.FIFTH.getPrize());
        assertEquals(0, Rank.MISS.getPrize());
    }
}
