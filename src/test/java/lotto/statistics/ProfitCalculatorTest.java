package lotto.statistics;

import lotto.result.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률을_계산한다() {
        Map<LottoRank, Integer> resultStatistics = new HashMap<>();
        resultStatistics.put(LottoRank.FIRST, 0);
        resultStatistics.put(LottoRank.FIFTH, 1);

        int totalPurchaseAmount = 8_000;

        double profitRate = ProfitCalculator.calculateProfitRate(resultStatistics, totalPurchaseAmount);

        assertThat(profitRate).isEqualTo(62.5);
    }
}
