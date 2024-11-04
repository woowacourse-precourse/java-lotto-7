package lotto.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReturnCalculatorTest {
    private ReturnCalculator returnCalculator = new ReturnCalculator();

    @Test
    public void 올바른_수익률을_반환하는지_테스트() {
        // given
        int spentMoney1 = 8000;
        int winningMoney1 = 5000 + 5000 + 50000;
        int spentMoney2 = 12000;
        int winningMoney2 = 5000;

        // when
        double returnRate1 = returnCalculator.getReturnRate(spentMoney1, winningMoney1);
        double returnRate2 = returnCalculator.getReturnRate(spentMoney2, winningMoney2);

        // then
        assertEquals(750, returnRate1);
        assertEquals(41.7, returnRate2);
    }
}