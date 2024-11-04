package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @Test
    void calculateTotalProfit() {
        List<MatchCountMessage> winningResults = List.of(
                MatchCountMessage.THREE_MATCH,
                MatchCountMessage.FIVE_MATCH,
                MatchCountMessage.SIX_MATCH
        );

        long totalProfit = ProfitCalculator.calculateTotalProfit(winningResults);
        assertThat(totalProfit).isEqualTo(2000500000);
    }

    @Test
    void calculateProfitRate() {
        long totalProfit = 2000500000;
        long purchaseAmount = 5000;

        double profitRate = ProfitCalculator.calculateProfitRate(totalProfit, purchaseAmount);
        assertThat(profitRate).isEqualTo(40010000.0);
    }
}