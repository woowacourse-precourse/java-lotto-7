package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyCalculatorTest {

    private final List<Integer> winningAmount = List.of(
            5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
    );

    long totalAmount = winningAmount.stream()
            .mapToLong(Integer::longValue)
            .sum();

    @Test
    void 당첨_금액_계산_테스트() {
        List<Integer> matchNumberCount = List.of(1, 1, 1, 1, 1, 1, 1, 1);
        MoneyCalculator moneyCalculator = new MoneyCalculator(matchNumberCount);

        long winningAmount = moneyCalculator.getWinningAmount();
        assertEquals(totalAmount, winningAmount);
    }

    @DisplayName("8,000원으로 3등이 당첨되었을 때의 수익률")
    @Test
    void 수익률_계산_테스트() {
        int inputMoney = 8_000;
        List<Integer> matchNumberCount = List.of(0, 0, 0, 1, 0, 0, 0, 0);
        MoneyCalculator moneyCalculator = new MoneyCalculator(matchNumberCount);

        long winningAmount = moneyCalculator.getWinningAmount();
        String profitMargin = moneyCalculator.getProfitMargin(inputMoney, winningAmount);

        // 8,000원 으로 5,000이윤 => 수익률: 62.5%
        assertEquals("62.5%", profitMargin);
    }

}