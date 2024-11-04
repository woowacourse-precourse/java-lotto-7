package lotto;

import lotto.model.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    private Statistics statistics;

    @BeforeEach
    public void setUp() {
        statistics = new Statistics();
    }

    @Test
    public void testMultipleUpdates() {
        statistics.updateStatistics(3, false);
        statistics.updateStatistics(4, false);
        statistics.updateStatistics(5, true);
        statistics.updateStatistics(5, false);
        statistics.updateStatistics(6, false);

        assertEquals(1, statistics.getMatchCount("3개 일치"));
        assertEquals(1, statistics.getMatchCount("4개 일치"));
        assertEquals(1, statistics.getMatchCount("5개 일치"));
        assertEquals(1, statistics.getMatchCount("5개 일치, 보너스 볼 일치"));
        assertEquals(1, statistics.getMatchCount("6개 일치"));
    }

    @Test
    void 당첨률_정상_계산() {
        statistics.updateStatistics(3, false);
        assertEquals(62.5, statistics.getTotalPriceRate(8));
    }

}