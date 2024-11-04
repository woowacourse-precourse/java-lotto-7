package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticTest {
    @BeforeAll
    static void setUp(){
        WinningStatistic.createStatistics();
        WinningStatistic.incrementMatchCount(NumberMatchType.MATCH_4);
        WinningStatistic.incrementMatchCount(NumberMatchType.MATCH_4);
        WinningStatistic.incrementMatchCount(NumberMatchType.MATCH_5_BONUS);
    }

    @Test
    @DisplayName("NumberMatchType 값 증가 확인하기")
    public void numberMatchType_값_증가_테스트() {
        String output = WinningStatistic.getWinningStatistics();
        String expectedOutput = "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 2개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";
        assertThat(output.trim()).isEqualTo(expectedOutput.trim());
    }

    @Test
    @DisplayName("수익률 계산 확인하기")
    public void 수익률_계산_테스트() {
        double revenueRate = WinningStatistic.getRate(50000);
        String rate = String.format("%.1f", revenueRate);
        assertThat(rate).isEqualTo("60.2");
    }
}