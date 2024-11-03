package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReturnRateCalculatorTest {

    private final ReturnRateCalculator returnRateCalculator = new ReturnRateCalculator();

    @DisplayName("당첨금과 구매금이 주어졌을 때 올바른 당첨금 비율을 계산한다.")
    @Test
    public void calculateReturnRate_ValidValues_ShouldReturnCorrectRate() {
        double totalWinningAmount = 150;
        double totalPurchaseAmount = 100;

        double returnRate = returnRateCalculator.calculateReturnRate(totalWinningAmount, totalPurchaseAmount);

        assertThat(returnRate).isEqualTo(150.0);
    }

    @DisplayName("당첨금과 구매금이 같을 경우 당첨금 비율은 100%여야 한다.")
    @Test
    public void calculateReturnRate_SameValues_ShouldReturnHundred() {
        double totalWinningAmount = 100;
        double totalPurchaseAmount = 100;

        double returnRate = returnRateCalculator.calculateReturnRate(totalWinningAmount, totalPurchaseAmount);

        assertThat(returnRate).isEqualTo(100.0);
    }

    @DisplayName("당첨금이 0일 경우 당첨금 비율은 0이어야 한다.")
    @Test
    public void calculateReturnRate_ZeroEarnings_ShouldReturnZero() {
        double totalWinningAmount = 0;
        double totalPurchaseAmount = 100;

        double returnRate = returnRateCalculator.calculateReturnRate(totalWinningAmount, totalPurchaseAmount);

        assertThat(returnRate).isEqualTo(0.0);
    }
}
