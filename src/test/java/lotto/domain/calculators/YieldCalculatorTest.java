package lotto.domain.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    @Test
    void 수익률_계산_확인() {
        YieldCalculator yieldCalculator = new YieldCalculator();

        float expected = yieldCalculator.calculate(5000L, 1000);
        float actual = 500;

        assertEquals(expected, actual);
    }

}