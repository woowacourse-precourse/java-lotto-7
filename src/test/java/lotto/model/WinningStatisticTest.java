package lotto.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {

    @Test
    @DisplayName("수익률이 없는 상태로 WinningStatistic 인스턴스 생성")
    void testWinningStatisticCreation() {
        WinningStatistic statistic = new WinningStatistic();
        assertTrue(statistic.toString().contains("총 수익률은 -1.0%입니다."));
    }

    @Test
    @DisplayName("등수별 당첨 횟수 증가")
    void testAddPrizeCount() {
        WinningStatistic statistic = new WinningStatistic();
        statistic.addPrizeCount(PrizeTier.FIRST);
        statistic.addPrizeCount(PrizeTier.FIRST);
        assertTrue(statistic.toString().contains("6개 일치 (2,000,000,000원) - 2개"));
    }

    @Test
    @DisplayName("수익률과 함께 WinningStatistic 인스턴스 생성")
    void testCreateWithProfitRate() {
        WinningStatistic statistic = new WinningStatistic();
        WinningStatistic updatedStatistic = statistic.createWithProfitRate(statistic, 150.0);
        assertTrue(updatedStatistic.toString().contains("총 수익률은 150.0%입니다."));
    }
}
