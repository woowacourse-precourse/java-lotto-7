package lotto.analytics;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnalyzerTest {

    @DisplayName("구입 금액과 총 금액으로 수익률을 계산해 반환한다 1")
    @Test
    void shouldCalculateRateWhenRequestAnalyzer() {
        // give
        Analyzer analyzer = new Analyzer();
        int payment = 8000;
        long totalPrizeAmount = 5000;
        double expectedResult = 62.5;

        // when
        double actualResult = analyzer.calculateRate(payment, totalPrizeAmount);

        // then
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("구입 금액과 총 금액으로 수익률을 계산해 반환한다 2")
    @Test
    void shouldCalculateRateWhenRequestAnalyzer2() {
        // give
        Analyzer analyzer = new Analyzer();
        int payment = 8000;
        long totalPrizeAmount = 0;
        double expectedResult = 0.0;

        // when
        double actualResult = analyzer.calculateRate(payment, totalPrizeAmount);

        // then
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}
