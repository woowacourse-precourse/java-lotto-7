package lotto.application.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @Test
    void calculateProfit() {
        //given
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //when
        double profit = profitCalculator.calculateProfit(5000, 8000);

        //then
        Assertions.assertThat(profit).isEqualTo(62.5);
    }
}