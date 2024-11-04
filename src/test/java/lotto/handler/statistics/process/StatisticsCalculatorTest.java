package lotto.handler.statistics.process;

import java.util.HashMap;
import lotto.handler.purchase.process.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsCalculatorTest {
    private StatisticsCalculator statisticsCalculator;
    private HashMap<WinningRank, Integer> rankCounts;
    private double purchaseAmount;

    @BeforeEach
    void StatisticsCalculator_당첨_등수_구매_금액_초기화() {
        rankCounts = getTestRankCounts();
        purchaseAmount = 5000;
        statisticsCalculator = new StatisticsCalculator();
    }

    @DisplayName("calculate시 String으로 \"1100.0\"가 나와야함")
    @Test
    void calculate_시_문자열_천백_퍼센트가_나와야함() {
        String expectedRate = "1100.0";

        Assertions.assertEquals(expectedRate, statisticsCalculator.calculate(rankCounts, purchaseAmount));
    }

    private HashMap<WinningRank, Integer> getTestRankCounts() {
        HashMap<WinningRank, Integer> testRankCounts = new HashMap<>();
        testRankCounts.put(WinningRank.FIRST, 0);
        testRankCounts.put(WinningRank.SECOND, 0);
        testRankCounts.put(WinningRank.THIRD, 0);
        testRankCounts.put(WinningRank.FOURTH, 1);
        testRankCounts.put(WinningRank.FIFTH, 1);
        return testRankCounts;
    }
}