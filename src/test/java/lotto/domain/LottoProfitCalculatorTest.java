package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "5000, 62.5",
            "50000, 625.0",
            "1500000, 18750.0",
            "30000000, 375000.0",
            "2000000000, 25000000.0"
    })
    @DisplayName("당첨 금액과 구입 금액으로 총 수익률을 구한다.")
    void calculateProfitRate(int condition, String expectedRate) {
        final int purchaseAmount = 8000;
        double profitRate = ((double) condition / purchaseAmount) * 100;
        String formattedProfitRate = String.format("%.1f", profitRate);

        assertThat(formattedProfitRate).isEqualTo(expectedRate);
    }

}