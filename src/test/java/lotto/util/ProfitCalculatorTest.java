package lotto.util;

import static lotto.util.ProfitCalculator.calculateProfit;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.Purchase;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    @Test
    void 수익률_계산() {
        Money prize = new Prize(5000);
        Money purchase = new Purchase(8000);
        double profit = 62.5;

        assertThat(calculateProfit((Prize) prize, (Purchase) purchase)).isEqualTo(profit);

    }
}