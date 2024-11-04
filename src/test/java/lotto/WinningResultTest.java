package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    @DisplayName("당첨금 계산이 정확한지 테스트한다.")
    @Test
    void calculateProfitRate_테스트() {
        WinningResult result = new WinningResult();

        // 3개 일치 1개(5,000원)
        result.addResult(3, false);

        int purchaseAmount = 8000; // 8장 구매
        double expectedRate = (5000.0 * 100) / purchaseAmount; // 62.5%

        assertThat(result.calculateProfitRate(purchaseAmount)).isEqualTo(expectedRate);
    }

    @DisplayName("2등 당첨(5개 + 보너스볼 일치)이 정확히 기록되는지 테스트한다.")
    @Test
    void addResult_이등당첨_테스트() {
        WinningResult result = new WinningResult();
        result.addResult(5, true);

        int purchaseAmount = 1000;
        double expectedRate = (30000000.0 * 100) / purchaseAmount;

        assertThat(result.calculateProfitRate(purchaseAmount)).isEqualTo(expectedRate);
    }
}