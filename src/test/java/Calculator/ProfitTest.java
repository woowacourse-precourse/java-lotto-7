package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    public void testCalculate() {
        // given
        int money = 1000;
        Map<Integer, Integer> tempResult = Map.of(1, 0, 2, 0, 3, 0, 4, 0, 5, 1);

        // when
        Profit profit = new Profit();
        double result = profit.calculate(tempResult, money);

        // then
        assertEquals(500.0, result);
    }
}
