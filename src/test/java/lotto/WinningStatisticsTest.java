package lotto;

import lotto.domain.money.Money;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @DisplayName("당첨 통계에서 각 등수별 당첨 개수를 조회한다")
    @Test
    void getWinningCount() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        rankCounts.put(LottoRank.FIRST, 1);
        rankCounts.put(LottoRank.SECOND, 1);
        rankCounts.put(LottoRank.THIRD, 1);

        WinningStatistics statistics = WinningStatistics.from(rankCounts);

        assertThat(statistics.getWinningCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(statistics.getWinningCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(statistics.getWinningCount(LottoRank.THIRD)).isEqualTo(1);
    }

    @DisplayName("당첨금 총액을 계산한다")
    @Test
    void calculateTotalPrize() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        rankCounts.put(LottoRank.FIFTH, 1);  // 5,000원
        rankCounts.put(LottoRank.FOURTH, 1); // 50,000원

        WinningStatistics statistics = WinningStatistics.from(rankCounts);
        Money expectedTotal = Money.from(55_000); // 5,000 + 50,000

        assertThat(statistics.calculateTotalPrize()).isEqualTo(expectedTotal);
    }
}