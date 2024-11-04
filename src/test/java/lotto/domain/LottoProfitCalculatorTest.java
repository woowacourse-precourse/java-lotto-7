package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCalculatorTest {

    @DisplayName("수익률을 계산한다")
    @Test
    void calculateProfitRate() {
        LottoProfitCalculator calculator = new LottoProfitCalculator(3000);
        calculator.addPrize(5000);
        assertThat(calculator.getProfitRate()).isEqualTo(166.7);
    }

    @DisplayName("당첨금이 없으면 수익률은 0이다")
    @Test
    void calculateProfitRateWithNoPrize() {
        LottoProfitCalculator calculator = new LottoProfitCalculator(3000);
        assertThat(calculator.getProfitRate()).isEqualTo(0.0);
    }
}