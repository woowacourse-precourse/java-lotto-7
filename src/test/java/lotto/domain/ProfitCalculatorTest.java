package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ProfitCalculatorTest {

    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    @DisplayName("수익률 계산하는 기능 테스트")
    @Test
    void 수익률은_소수점_둘째자리에서_반올림해야_한다() {

        assertThat(profitCalculator.calculateProfit(5000, 5)).isEqualTo("100.0");
        assertThat(profitCalculator.calculateProfit(10000, 5)).isEqualTo("200.0");
        assertThat(profitCalculator.calculateProfit(2500, 5)).isEqualTo("50.0");
    }

}
