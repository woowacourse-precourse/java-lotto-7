package lotto.models;

import lotto.utils.Prize;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YieldCalculatorTest {

    @Test
    void 수익률_계산이_정상적으로_동작하는지_확인한다() {
        Statistics statistics = new Statistics();
        statistics.increment(Prize.THREE);
        statistics.increment(Prize.FOUR);
        statistics.increment(Prize.FIVE);

        YieldCalculator yieldCalculator = new YieldCalculator(statistics);

        int totalPurchaseAmount = 10000;
        double expectedYield = ((5000 + 50000 + 1500000) / (double) totalPurchaseAmount) * 100;
        double actualYield = yieldCalculator.calculateYield(totalPurchaseAmount);

        assertEquals(expectedYield, actualYield, 0.001);
    }

    @Test
    void 수익이_없는_경우_수익률이_0인지_확인한다() {
        Statistics statistics = new Statistics();
        YieldCalculator yieldCalculator = new YieldCalculator(statistics);

        int totalPurchaseAmount = 10000;
        double actualYield = yieldCalculator.calculateYield(totalPurchaseAmount);

        assertEquals(0.0, actualYield, 0.001);
    }
}
