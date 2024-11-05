package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EarningRateTest {

    @Test
    void earningRate_shouldReturnCorrectEarningRate() {
        // Given
        int totalPrize = 2000000; // 예시: 총 당첨금
        int moneySpent = 1000000; // 예시: 소비한 금액

        LottoStatisticsCalculator calculator = new LottoStatisticsCalculator();

        // When
        double earningRate = calculator.EarningRate(totalPrize, moneySpent);

        // Then
        assertThat(earningRate).isEqualTo(200.0); // 수익률 계산: (2000000 / 1000000) * 100 = 200.0
    }
}