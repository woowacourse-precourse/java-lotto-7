package lotto.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.WinningRank.*;

class WinningRankTest {
    @Test
    public void getWinningRankTest() {
        // given
        List<Integer> matchedCounts = List.of(5, 5, 3, 1, 6);
        List<Boolean> isMatchedBonusNumbers = List.of(true, false, true, true, true);
        List<WinningRank> expectedWinningRanks = List.of(SECOND_PLACE, THIRD_PLACE, FIFTH_PLACE
                , NOT_IN_PLACE, FIRST_PLACE);

        // when
        List<WinningRank> actualWinningRanks = new ArrayList<>();
        for(int i=0; i<expectedWinningRanks.size(); i++) {
            actualWinningRanks.add(WinningRank.determine(matchedCounts.get(i),
                    isMatchedBonusNumbers.get(i)));
        }

        // then
        for(int i=0; i<expectedWinningRanks.size(); i++) {
            Assertions.assertEquals(expectedWinningRanks.get(i), actualWinningRanks.get(i));
        }
    }
}