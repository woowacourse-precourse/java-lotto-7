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
        double roundProfitRate = Math.round(profitRate * 100) / 100.0;
        // then
        Assertions.assertThat(roundProfitRate).isEqualTo(62.5);
    }

}