package lotto;

import static lotto.constant.WinningRank.FIFTH;
import static lotto.constant.WinningRank.FIRST;
import static lotto.constant.WinningRank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.WinningRank;
import lotto.service.CalculateProfitRateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateProfitRateServiceTest {
    @Test
    @DisplayName("총 당첨 금액과 구매 금액을 이용하여 수익률을 계산한다")
    void 수익률_계산() {
        Map<WinningRank, Integer> results = new HashMap<>();
        results.put(FIRST, 1);
        results.put(SECOND, 2);
        results.put(FIFTH, 5);

        int totalPurchaseAmount = 1000000;
        int totalPrize = (1 * 2_000_000_000) + (2 * 30_000_000) + (5 * 5_000);

        double expectedProfitRate = (((double) totalPrize / 1000) / totalPurchaseAmount) * 100;
        double actualProfitRate = CalculateProfitRateService.calculateProfitRate(results, totalPurchaseAmount);

        assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }
}
