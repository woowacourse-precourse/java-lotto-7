package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 당첨_결과_초기값_생성_테스트() {
        //when
        Map<Rank, Integer> rankIntegerMap = Rank.makeRankResult();

        //then
        assertEquals(rankIntegerMap.get(Rank.FIRST), 0);
        assertEquals(rankIntegerMap.get(Rank.SECOND), 0);
        assertEquals(rankIntegerMap.get(Rank.THIRD), 0);
        assertEquals(rankIntegerMap.get(Rank.FOURTH), 0);
        assertEquals(rankIntegerMap.get(Rank.FIFTH), 0);
        assertEquals(rankIntegerMap.get(Rank.NONE), 0);
    }

    @Test
    void 등수_찾기_테스트() {
        //given
        int countNumber1 =  5;
        int countNumber2 = 2;
        boolean needBonusNumber = true;
        boolean noNeedBonusNumber = false;

        //when
        Rank rank1 = Rank.getRank(countNumber1, needBonusNumber);
        Rank rank2 = Rank.getRank(countNumber1, noNeedBonusNumber);
        Rank rank3 = Rank.getRank(countNumber2, noNeedBonusNumber);

        //then
        assertEquals(rank1, Rank.SECOND);
        assertEquals(rank2, Rank.THIRD);
        assertEquals(rank3, Rank.NONE);
    }
}