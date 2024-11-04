package lotto.winningResult;

import static lotto.lotto.MatchingCondition.THREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.lotto.MatchingCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RevenueRateTest {

    @Test
    @DisplayName("수익률을 계산한다")
    void calculateRevenue() {
        // given
        int buyingAmount = 8000;
        List<MatchingCondition> conditions = List.of(THREE);
        TotalWinningResult totalWinningResult = TotalWinningResult.from(conditions);
        Map<WinningResultInfo, Long> winningResultStatistics = totalWinningResult.getWinningResultMap();
        RevenueRate revenueRate = RevenueRate.of(buyingAmount, winningResultStatistics);

        // when
        double getRevenueRate = revenueRate.getRevenueRate();

        // then
        assertThat(getRevenueRate).isEqualTo(0.625d);
    }
}
