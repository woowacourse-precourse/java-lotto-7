package lotto.application.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수익률 계산기에 관한 기능을 확인한다.")
class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산을 확인한다.")
    void calculateProfit() {
        //given
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //when
        double profit = profitCalculator.calculateProfit(5000, 8000);

        //then
        Assertions.assertThat(profit).isEqualTo(62.5);
    }
}