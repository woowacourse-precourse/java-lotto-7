package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 해당없음_Rank_반환_확인(){
        int matchCount = 1;
        boolean hasBonus = false;

        assertEquals(Rank.findRank(matchCount,hasBonus), Rank.NOTHING);
    }

    @Test
    void 보너스_결과가_같은_Rank_반환_확인(){
        int matchCount = 6;
        boolean hasBonus = false;

        assertEquals(Rank.findRank(matchCount,hasBonus), Rank.FIRST);
    }

    @Test
    void 보너스_결과가_다른_Rank_반환_확인(){
        int matchCount = 6;
        boolean hasBonus = true;

        assertEquals(Rank.findRank(matchCount,hasBonus), Rank.FIRST);
    }

    @Test
    void 이등_Rank_반환_확인(){
        int matchCount = 5;
        boolean hasBonus = true;

        assertEquals(Rank.findRank(matchCount,hasBonus), Rank.SECOND);
    }

    @Test
    void 삼등_Rank_반환_확인(){
        int matchCount = 5;
        boolean hasBonus = false;

        assertEquals(Rank.findRank(matchCount,hasBonus), Rank.THIRD);
    }


}