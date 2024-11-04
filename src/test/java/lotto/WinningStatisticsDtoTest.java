package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningStatisticsDtoTest {

    @Test
    public void 당첨_통계_구하기() {
    	//given
        Map<Rank, Integer> expectedWinningStatistics = new HashMap<>();
        expectedWinningStatistics.put(Rank.THREE, 1);
        expectedWinningStatistics.put(Rank.FOUR, 0);
        expectedWinningStatistics.put(Rank.FIVE, 0);
        expectedWinningStatistics.put(Rank.FIVE_AND_BONUS, 0);
        expectedWinningStatistics.put(Rank.SIX, 0);
        expectedWinningStatistics.put(Rank.ETC, 0);

        WinningStatisticsDto testWinningStatisticsDto = new WinningStatisticsDto(expectedWinningStatistics);

    	//when
        Map<Rank, Integer> actualWinningStatistics = testWinningStatisticsDto.getWinningStatistics();

        //then
        assertTrue(actualWinningStatistics.entrySet().equals(expectedWinningStatistics.entrySet()));

    }

    @Test
    public void 수익률_구하기() {
    	//given
        Map<Rank, Integer> testWinningStatistics = new HashMap<>();
        testWinningStatistics.put(Rank.THREE, 1);
        testWinningStatistics.put(Rank.FOUR, 0);
        testWinningStatistics.put(Rank.FIVE, 0);
        testWinningStatistics.put(Rank.FIVE_AND_BONUS, 0);
        testWinningStatistics.put(Rank.SIX, 0);
        testWinningStatistics.put(Rank.ETC, 0);

        WinningStatisticsDto testWinningStatisticsDto = new WinningStatisticsDto(testWinningStatistics);

    	int testPurchaseAmount = 40000;
        double expectedLottoYield = 12.5;
    	//when
        double actualLottoYield = testWinningStatisticsDto.getLottoYield(testPurchaseAmount);

        //then
        assertEquals(expectedLottoYield, actualLottoYield);
    }
}