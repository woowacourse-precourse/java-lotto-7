package lotto.model.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnCalculatorTest {

    private final RateOfReturnCalculator calculator = new RateOfReturnCalculator();

    @Test
    @DisplayName("총 티켓 수와 총 상금에 따라 반환율을 정확히 계산해야 한다.")
    void shouldCalculateRateOfReturnCorrectly() {
        int totalTickets = 10;
        double totalPrize = 5_000;

        double rateOfReturn = calculator.calculate(totalTickets, totalPrize);

        assertEquals(50.0, rateOfReturn);
    }

    @Test
    @DisplayName("총 상금이 0일 경우 반환율은 0%여야 한다.")
    void shouldReturnZeroWhenTotalPrizeIsZero() {
        int totalTickets = 10;
        double totalPrize = 0;

        double rateOfReturn = calculator.calculate(totalTickets, totalPrize);

        assertEquals(0.0, rateOfReturn);
    }

    @Test
    @DisplayName("총 티켓 수와 총 상금이 동일할 경우 반환율은 100%여야 한다.")
    void shouldReturnOneHundredPercentWhenTotalTicketsEqualsTotalPrize() {
        int totalTickets = 1;
        double totalPrize = 1_000;

        double rateOfReturn = calculator.calculate(totalTickets, totalPrize);

        assertEquals(100.0, rateOfReturn);
    }

}
