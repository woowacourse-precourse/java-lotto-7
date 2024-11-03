package lotto.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoYieldCalculatorTest {

    private LottoYieldCalculator yieldCalculator;

    @BeforeEach
    public void setUp() {
        yieldCalculator = new LottoYieldCalculator(10000);
    }

    @Test
    public void 테스트_수익률_계산_기능() {
        yieldCalculator.addPrize(15000);
        assertEquals(150.0, yieldCalculator.calculateYield(), 0.001);

        yieldCalculator.addPrize(5000);
        assertEquals(200.0, yieldCalculator.calculateYield(), 0.001);
    }

    @Test
    public void 테스트_투자금이_0인_경우_수익률은_0() {
        LottoYieldCalculator zeroInvestmentCalculator = new LottoYieldCalculator(0);
        assertEquals(0.0, zeroInvestmentCalculator.calculateYield(), 0.001);
    }

    @Test
    public void 테스트_수익률_출력() {
        yieldCalculator.addPrize(15000);
        yieldCalculator.printYield(); // This will print the yield to the console
    }
}
