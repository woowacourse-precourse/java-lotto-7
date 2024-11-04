package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsServiceTest {

    private final StatisticsService statisticsService = new StatisticsService();

    @Test
    @DisplayName("calculateRateEarning 메서드가 올바른 수익률을 계산하는지 테스트")
    void shouldCalculateCorrectRateEarning() {
        Map<LottoResult, Integer> lottoResultCount = new HashMap<>();
        lottoResultCount.put(LottoResult.FIVE, 1);
        lottoResultCount.put(LottoResult.THREE, 3);
        int purchaseAmount = 5000;

        double rateEarning = statisticsService.calculateRateEarning(lottoResultCount, purchaseAmount);

        assertEquals(30300.0, rateEarning, "수익률 계산이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("구입 금액이 0일 때 예외가 발생하는지 테스트")
    void shouldThrowExceptionWhenPurchaseAmountIsZero() {
        Map<LottoResult, Integer> lottoResultCount = new HashMap<>();

        assertThatThrownBy(() -> statisticsService.calculateRateEarning(lottoResultCount, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 음수일 때 예외가 발생하는지 테스트")
    void shouldThrowExceptionWhenPurchaseAmountIsNegative() {
        Map<LottoResult, Integer> lottoResultCount = new HashMap<>();

        assertThatThrownBy(() -> statisticsService.calculateRateEarning(lottoResultCount, -1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }
}
