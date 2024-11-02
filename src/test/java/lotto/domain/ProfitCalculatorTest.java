package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        int purchaseAmount = 8000;
        int totalWinnings = 5000;

        // when
        double profitRate = ProfitCalculator.calculateProfitRate(totalWinnings, purchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("수익률이 0%인 경우")
    @Test
    void calculateProfitRate_zeroProfit() {
        // given
        int purchaseAmount = 10000;
        int totalWinnings = 0;

        // when
        double profitRate = ProfitCalculator.calculateProfitRate(totalWinnings, purchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(0.0);
    }

    @DisplayName("수익률이 100%인 경우")
    @Test
    void calculateProfitRate_fullProfit() {
        // given
        int purchaseAmount = 5000;
        int totalWinnings = 5000;

        // when
        double profitRate = ProfitCalculator.calculateProfitRate(totalWinnings, purchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(100.0);
    }

}