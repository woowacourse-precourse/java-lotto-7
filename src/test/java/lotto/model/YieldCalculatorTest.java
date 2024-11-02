package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    YieldCalculator yieldCalculator = new YieldCalculator();

    @Test
    void 당첨금에_따른_수익률을_반환한다(){
        int purchaseAmount = 10000;
        int prizeMoney = 55000;
        int rateOfReturn = yieldCalculator.calculate(purchaseAmount,prizeMoney);

        int expectedRateOfReturn = prizeMoney/purchaseAmount*100;

        assertEquals(rateOfReturn, expectedRateOfReturn);
    }

}