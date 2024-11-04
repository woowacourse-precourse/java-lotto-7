package lotto.service;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoStatisticsServiceTest {

    private final LottoStatisticsService statisticsService = new LottoStatisticsService();

    @Test
    @DisplayName("총 당첨 금액 계산 확인")
    void calculateTotalPrize_validResults_shouldReturnCorrectTotalPrize() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        results.put(Rank.FIRST, 1);
        results.put(Rank.SECOND, 0);
        results.put(Rank.THIRD, 2);
        results.put(Rank.FOURTH, 3);
        results.put(Rank.FIFTH, 4);

        int totalPrize = statisticsService.calculateTotalPrize(results);

        int expectedTotalPrize = Rank.FIRST.getPrize() * 1
                + Rank.THIRD.getPrize() * 2
                + Rank.FOURTH.getPrize() * 3
                + Rank.FIFTH.getPrize() * 4;

        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }

    @Test
    @DisplayName("수익률 계산 확인")
    void calculateProfitRate_validInput_shouldReturnCorrectProfitRate() {
        int totalPrize = 1000000;
        int purchaseAmount = 5000;

        double profitRate = statisticsService.calculateProfitRate(totalPrize, purchaseAmount);

        assertThat(profitRate).isEqualTo(20000.0);
    }
}
