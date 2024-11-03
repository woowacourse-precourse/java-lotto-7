package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import lotto.model.Result;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 금액을_개수로_변환한다() {
        assertEquals(6, Calculator.calculateLottoTicketNumber(6000));
    }

    @Test
    void 수익률을_계산한다() {
        Map<Result, Integer> results = new HashMap<>();
        results.put(Result.FIRST, 0);
        results.put(Result.SECOND, 0);
        results.put(Result.THIRD, 0);
        results.put(Result.FORTH, 0);
        results.put(Result.FIFTH, 1);
        assertEquals("62.5", Calculator.calculateProfit(8000, results));
    }
}
