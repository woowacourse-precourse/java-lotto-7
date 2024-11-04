package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankResultTest {

    @DisplayName("당첨 결과에 따른 총 당첨 금액을 정확히 계산한다.")
    @Test
    void 총_당첨_금액_계산() {
        Map<Rank, Long> rankResult = Map.of(
                Rank.FIRST, 1L,
                Rank.THIRD, 2L
        );
        RankResult result = new RankResult(rankResult);

        Money winningAmount = result.calculateWinningAmount();

        assertThat(winningAmount.toLong()).isEqualTo(
                Rank.FIRST.getPrize().toLong() +
                        Rank.THIRD.getPrize().toLong() * 2
        );
    }

    @DisplayName("구입 금액에 대한 수익률을 정확히 계산한다.")
    @Test
    void 수익률_계산() {
        Map<Rank, Long> rankResult = Map.of(
                Rank.FIRST, 1L,
                Rank.FOURTH, 3L
        );
        RankResult result = new RankResult(rankResult);
        Money purchaseAmount = new Money(5000L);

        double rateOfEarning = result.calculateRateOfResult(purchaseAmount);
        double expectedRate = result.calculateWinningAmount().toLong() / (double) purchaseAmount.toLong();

        assertThat(rateOfEarning).isEqualTo(expectedRate);
    }

}