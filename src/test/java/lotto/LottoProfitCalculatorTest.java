package lotto;

import lotto.service.LottoProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static lotto.constant.LottoMatchConstant.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoProfitCalculatorTest {
    private final LottoProfitCalculator calculator = new LottoProfitCalculator();

    @DisplayName("구매 금액과 통계에 따라 수익률이 계산된다.")
    @Test
    void 수익률_계산() {
        LinkedHashMap<String, Integer> userStatistics = new LinkedHashMap<>();
        userStatistics.put(MATCH_3.getMatch(), 1);
        userStatistics.put(MATCH_4.getMatch(), 0);
        userStatistics.put(MATCH_5.getMatch(), 0);
        userStatistics.put(MATCH_5_WITH_BONUS.getMatch(), 0);
        userStatistics.put(MATCH_6.getMatch(), 0);

        int purchaseAmount = 8000;
        double rateOfReturn = calculator.calculateRateOfReturn(userStatistics, purchaseAmount);

        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
