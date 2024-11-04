package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankCountTest {
    @Test
    void 생성할_때_count는_0이_된다() {
        Rank rank = Rank.FIRST;
        RankCount rankCount = new RankCount(rank);

        int count = rankCount.getCount();

        assertEquals(0, count, "생성할 때 count 값은 0이어야 한다.");
    }

    @Test
    void count를_증가시킨다() {
        Rank rank = Rank.FIRST;
        RankCount rankCount = new RankCount(rank);

        rankCount.incrementCount();
        int countAfterIncrement = rankCount.getCount();

        assertEquals(1, countAfterIncrement, "count는 1");

        rankCount.incrementCount();
        int countAfterSecondIncrement = rankCount.getCount();

        assertEquals(2, countAfterSecondIncrement, "count는 2");
    }
}