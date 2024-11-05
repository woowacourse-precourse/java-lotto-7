package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitCalculatorServiceTest {

    private ProfitCalculatorService profitCalculatorService;

    @BeforeEach
    void setUp() {
        profitCalculatorService = new ProfitCalculatorService();
    }

    @Test
    void 수익률_계산_정상_케이스() {
        Map<Rank, Long> rankCount = new HashMap<>();
        rankCount.put(Rank.FIFTH, 2L); //5등 2개

        int totalCost = 100_000; // 10개의 로또 구매

        double profit = profitCalculatorService.calculateProfit(rankCount, totalCost);
        assertThat(profit).isEqualTo(10.0);
    }

    @Test
    void 수익률_계산_총_구입_금액_0일_경우() {
        Map<Rank, Long> rankCount = new HashMap<>();

        int totalCost = 0;

        double profit = profitCalculatorService.calculateProfit(rankCount, totalCost);
        assertThat(profit).isEqualTo(0.0);
    }

    @Test
    void 수익률_계산_수익_없는_경우() {
        Map<Rank, Long> rankCount = new HashMap<>();

        int totalCost = 100_000;

        double profit = profitCalculatorService.calculateProfit(rankCount, totalCost);
        assertThat(profit).isEqualTo(0.0);
    }
}
