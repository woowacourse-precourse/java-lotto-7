package lotto.system.formater.profit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import lotto.system.utils.PrizeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {
    @Test
    @DisplayName("수익률 0 계산 테스트")
    void calculateProfitRate() {

        // given
        int totalPurchaseAmount = 1000;
        ProfitRate profitRate = ProfitRateCalculator.calculateProfitRate(Map.of(), totalPurchaseAmount);

        // when
        double actual = profitRate.profitRate();

        // then
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("수익률 100 계산 테스트")
    void calculateProfitRate2() {

        // given
        int totalPurchaseAmount = 5000;
        ProfitRate profitRate = ProfitRateCalculator.calculateProfitRate(Map.of(PrizeType.FIFTH_PRIZE, 1), totalPurchaseAmount);

        // when
        double actual = profitRate.profitRate();

        // then
        assertEquals(100, actual);
    }
}