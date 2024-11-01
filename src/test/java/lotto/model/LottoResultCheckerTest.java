package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCheckerTest {

    @Test
    @DisplayName("등수와 상금으로 수익률 계산 테스트, 수익률 소수점 둘째 자리에서 반올림")
    void profitCalculationTest() {
        Ranking rank = Ranking.FIRST;
        int purchaseCount = 5;
        int winningPrize = rank.getPrize();
        double profit = LottoResultChecker.calculateProfit(purchaseCount, winningPrize);

        assertThat(profit).isEqualTo(40000000.0);
    }

}
