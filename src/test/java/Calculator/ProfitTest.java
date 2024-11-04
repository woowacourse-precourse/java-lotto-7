package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    public void testCalculate() {
        // given
        int money = 1000;
        List<Integer> tempResult = List.of(0, 0, 0, 0, 0, 0, 1);

        // when
        Profit profit = new Profit();
        double result = profit.calculate(tempResult, money);

        // then
        assertEquals(0, result);
    }
}
