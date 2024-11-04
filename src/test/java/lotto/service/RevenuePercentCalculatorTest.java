package lotto.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RevenuePercentCalculatorTest {

    @Test
    void getRevenuePercent_기능_테스트() {
        RevenuePercentCalculator calculator = new RevenuePercentCalculator(List.of(2L, 1L, 2L, 0L, 0L, 0L));
        assertTrue(calculator.getRevenuePercent().compareTo(new BigDecimal("41200000")) == 0);
    }
}
