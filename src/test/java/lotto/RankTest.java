package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    public void 당첨_순위_구하기() {
    	//given
    	int testMatchingCount = 3;
        boolean testIsBonusMatched = false;

    	//when
        Rank actualRank = Rank.getRank(testMatchingCount, testIsBonusMatched);

    	//then
        assertEquals(Rank.THREE, actualRank);
    }
}