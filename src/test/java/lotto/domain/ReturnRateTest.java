package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnRateTest {

    @Test
    @DisplayName("총 지불 금액과 당첨 금액으로 수익률을 계산한다")
    void calculateProfitRate() {
        int totalPayment = 10000;
        long totalPrize = 15000;

        ReturnRate rate = ReturnRate.of(totalPayment, totalPrize);

        double expectedRate = 150.0;
        assertEquals(expectedRate, rate.getReturnRate(), 0.01);
    }

    @Test
    @DisplayName("총 지불 금액이 당첨 금액보다 많을 경우 수익률이 100% 이하이다")
    void profitRateLessThan100Percent() {
        int totalPayment = 10000;
        long totalPrize = 5000;

        ReturnRate rate = ReturnRate.of(totalPayment, totalPrize);

        double expectedRate = 50.0;
        assertEquals(expectedRate, rate.getReturnRate(), 0.01);
    }

    @Test
    @DisplayName("총 지불 금액과 당첨 금액이 같을 경우 수익률이 100%이다")
    void profitRateEquals100Percent() {
        int totalPayment = 10000;
        long totalPrize = 10000;

        ReturnRate rate = ReturnRate.of(totalPayment, totalPrize);

        double expectedRate = 100.0;
        assertEquals(expectedRate, rate.getReturnRate(), 0.01);
    }

    @Test
    @DisplayName("총 당첨 금액이 0일 경우 수익률을 0으로 계산한다")
    void profitRateZeroPayment() {
        int totalPayment = 10000;
        long totalPrize = 0;

        ReturnRate rate = ReturnRate.of(totalPayment, totalPrize);

        double expectedRate = 0.0;
        assertEquals(expectedRate, rate.getReturnRate(), 0.01);
    }
}
