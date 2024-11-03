package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RevenuePercentCalculatorTest {

    @Test
    void getRevenuePercent_기능_테스트() {
        RevenuePercentCalculator calculator = new RevenuePercentCalculator(List.of(2L, 1L, 2L, 0L, 0L, 0L));
        assertThat(calculator.getRevenuePercent()).isEqualTo(41200000f);
    }
}
