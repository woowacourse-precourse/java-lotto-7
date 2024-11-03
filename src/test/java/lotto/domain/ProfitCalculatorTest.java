package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    @DisplayName("당첨 내역이 없을 때 0.0%를 반환해야 한다.")
    @Test
    void shouldReturnZeroProfitWhenNoWinnings() {
        ProfitCalculator calculator = new ProfitCalculator();

        Map<LottoRank, Integer> rankCounts = Map.of();

        double profitRate = calculator.calculateProfitRate(rankCounts, 10000);

        assertThat(profitRate).isEqualTo(0.0);
    }

    @DisplayName("당첨 내역이 있을 때 수익률을 반환해야 한다.")
    @Test
    void shouldReturnProfitWhenHaveWinnings() {
        ProfitCalculator calculator = new ProfitCalculator();

        Map<LottoRank, Integer> rankCounts = Map.of(LottoRank.FIFTH, 1);

        double profitRate = calculator.calculateProfitRate(rankCounts, 8000);

        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("여러 랭크가 있을 때 수익률을 반환해야 한다.")
    @Test
    void shouldReturnCorrectProfitWhenMultipleWinnings() {
        ProfitCalculator calculator = new ProfitCalculator();

        Map<LottoRank, Integer> rankCounts = Map.of(
                LottoRank.FIFTH, 2,
                LottoRank.FOURTH, 1,
                LottoRank.SECOND, 1
        );

        double profitRate = calculator.calculateProfitRate(rankCounts, 15000);

        long totalPrize = (5000 * 2) + 50000 + 30000000;
        double expectedProfitRate = (double) totalPrize / 15000 * 100;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
