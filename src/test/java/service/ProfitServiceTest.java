package service;

import lotto.service.ProfitService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitServiceTest {

    @Test
    void calculateProfit_ShouldReturnCorrectProfit() {
        // given
        int prize = 10000; // 각 당첨금
        int count = 3;     // 당첨 횟수

        // when
        int profit = ProfitService.calculateProfit(prize, count);

        // then
        assertThat(profit).isEqualTo(30000); // 10000 * 3 = 30000
    }

    @Test
    void calculateProfitRate_ShouldReturnCorrectProfitRate() {
        // given
        int profit = 30000; // 수익
        int money = 10000;  // 투자금

        // when
        double profitRate = ProfitService.calculateProfitRate(profit, money);

        // then
        assertThat(profitRate).isEqualTo(300.0); // (30000 / 10000) * 100 = 300.0
    }
}
