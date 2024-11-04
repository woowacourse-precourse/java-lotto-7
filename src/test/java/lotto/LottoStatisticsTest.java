package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStatisticsTest {


    @Test
    @DisplayName("당첨금이 없는 경우 수익률은 0%")
    void calculateYieldWithNoWinning() {
        // given
        LottoStatistics statistics = new LottoStatistics();
        Map<LottoPrize, Integer> winningResult = createWinningResult(0, 0, 0, 0, 0);

        // when
        double yield = statistics.calculateYield(1000, winningResult);

        // then
        assertThat(yield).isZero();
    }

    @Test
    @DisplayName("구매 금액과 당첨금이 동일하면 수익률은 100%")
    void calculateYieldWithEqualMoneyAndPrize() {
        // given
        LottoStatistics statistics = new LottoStatistics();
        Map<LottoPrize, Integer> winningResult = createWinningResult(0, 0, 0, 0, 2);// 5,000 * 2 = 10,000원

        // when
        double yield = statistics.calculateYield(10000, winningResult);

        // then
        assertThat(yield).isEqualTo(100.0);
    }

    @Test
    @DisplayName("1등 당첨 시 수익률 계산")
    void calculateYieldWithFirstPrize() {
        // given
        LottoStatistics statistics = new LottoStatistics();
        Map<LottoPrize, Integer> winningResult = createWinningResult(1, 0, 0, 0, 0);

        // when
        double yield = statistics.calculateYield(1000, winningResult);

        // then
        // 예상 수익률: (2,000,000,000 / 1,000) * 100 = 200,000,000%
        assertThat(yield).isEqualTo(200_000_000.0);
    }

    @Test
    @DisplayName("복합 당첨 시 수익률 계산")
    void calculateYieldWithMultiplePrizes() {
        // given
        LottoStatistics statistics = new LottoStatistics();
        Map<LottoPrize, Integer> winningResult = createWinningResult(0, 0, 1, 1, 1);
        // 5,000 + 50,000 + 1,500,000 = 1,555,000원

        // when
        double yield = statistics.calculateYield(10000, winningResult);

        // then
        // 예상 수익률: (1,555,000 / 10,000) * 100 = 15,550%
        assertThat(yield).isEqualTo(15_550.0);
    }

    private Map<LottoPrize, Integer> createWinningResult(int match6, int match5Bonus, int match5, int match4, int match3) {
        Map<LottoPrize, Integer> result = new HashMap<>();
        result.put(LottoPrize.FIRST, match6);
        result.put(LottoPrize.SECOND, match5Bonus);
        result.put(LottoPrize.THIRD, match5);
        result.put(LottoPrize.FOURTH, match4);
        result.put(LottoPrize.FIFTH, match3);
        result.put(LottoPrize.NONE, 0);
        return result;
    }

}