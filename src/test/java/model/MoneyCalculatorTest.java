package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class MoneyCalculatorTest {

    private final List<Integer> winningAmount = List.of(
            5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
    );

    long totalAmount = winningAmount.stream()
            .mapToLong(Integer::longValue)
            .sum();

    @Test
    void 당첨_금액_계산() {
        List<Integer> matchNumberCount = List.of(1, 1, 1, 1, 1, 1, 1, 1);
        MoneyCalculator moneyCalculator = new MoneyCalculator(matchNumberCount);

        long winningAmount = moneyCalculator.getWinningAmount();
        assertEquals(totalAmount, winningAmount);

    }

}