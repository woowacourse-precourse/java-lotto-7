package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class ProfitTest {
    @Test
    void 총_수익률을_계산한다() {
        Map<Rank, Integer> lottoResult = Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 1,
                Rank.FOURTH, 2,
                Rank.FIFTH, 2,
                Rank.NONE, 100
        );
        long purchaseAmount = 210_000;
        Profit profit = new Profit(lottoResult, purchaseAmount);

        assertThat(profit.getProfitRate() * purchaseAmount)
                .isEqualTo(161_000_000);
    }
}
