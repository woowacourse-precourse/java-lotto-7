package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

public class ProfitCalculatorTest {

    @DisplayName("수익률이 0%일 때 테스트")
    @Test
    void shouldReturnZeroProfitRateWhenNoProfit() {
        Map<LottoRank, Integer> results = Map.of(
                LottoRank.NONE, 0
        );
        int amountSpent = 10000;

        double profitRate = ProfitCalculator.calculateProfitRate(results, amountSpent);

        assertThat(profitRate).isEqualTo(0.0);
    }

    @DisplayName("수익률이 100%일 때 테스트")
    @Test
    void shouldReturnHundredPercentProfitRateWhenBreakEven() {
        Map<LottoRank, Integer> results = Map.of(
                LottoRank.FOURTH, 1
        );
        int amountSpent = 50000;

        double profitRate = ProfitCalculator.calculateProfitRate(results, amountSpent);

        assertThat(profitRate).isEqualTo(100.0);
    }

    @DisplayName("수익률이 200%일 때 테스트")
    @Test
    void shouldReturnTwoHundredPercentProfitRateWhenDoubleProfit() {
        Map<LottoRank, Integer> results = Map.of(
                LottoRank.FOURTH, 2
        );
        int amountSpent = 50000;

        double profitRate = ProfitCalculator.calculateProfitRate(results, amountSpent);

        assertThat(profitRate).isEqualTo(200.0);
    }

    @DisplayName("수익률이 50%일 때 테스트")
    @Test
    void shouldReturnFiftyPercentProfitRateWhenHalfProfit() {
        Map<LottoRank, Integer> results = Map.of(
                LottoRank.FOURTH, 1
        );
        int amountSpent = 100000;

        double profitRate = ProfitCalculator.calculateProfitRate(results, amountSpent);

        assertThat(profitRate).isEqualTo(50.0);
    }
}
