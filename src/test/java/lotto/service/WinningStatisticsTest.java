package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("당첨 통계에 Rank를 추가하고 개수를 확인한다.")
    @Test
    void 당첨통계_Rank추가_개수확인() {
        // given
        WinningStatistics statistics = new WinningStatistics();

        // when
        statistics.addRank(Rank.FIRST);
        statistics.addRank(Rank.FIFTH);
        statistics.addRank(Rank.FIFTH);
        statistics.addRank(Rank.SECOND);

        // then
        assertThat(statistics.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(statistics.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.getCount(Rank.THIRD)).isEqualTo(0);
        assertThat(statistics.getCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(statistics.getCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(statistics.getCount(Rank.NONE)).isEqualTo(0);
    }

    @DisplayName("총 수익률을 정확하게 계산한다.")
    @Test
    void 총수익률_계산() {
        // given
        WinningStatistics statistics = new WinningStatistics();
        statistics.addRank(Rank.FIRST);  // 2,000,000,000원
        statistics.addRank(Rank.THIRD);  // 1,500,000원
        statistics.addRank(Rank.FIFTH);  // 5,000원
        int purchaseAmount = 15_000;     // 로또 3장 구입 (1장에 5,000원이라고 가정)

        // when
        double profitRate = statistics.calculateProfitRate(purchaseAmount);

        // then
        double expectedProfitRate = ((2_000_000_000 + 1_500_000 + 5_000) / (double) purchaseAmount) * 100;
        expectedProfitRate = Math.round(expectedProfitRate * 10) / 10.0;  // 소수점 둘째 자리에서 반올림
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
