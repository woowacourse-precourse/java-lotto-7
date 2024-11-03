package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoEvaluatorTest {

    private LottoEvaluator evaluator;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        evaluator = new LottoEvaluator(winningNumbers);
    }

    @Test
    @DisplayName("당첨 결과를 판단하여 Rank 개수를 올바르게 계산한다")
    void 당첨_결과를_판단한다() {
        // given
        List<Lotto> purchasedLotteries = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등 (보너스 포함)
                new Lotto(List.of(1, 2, 3, 4, 5, 10)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)) // 5등
        );

        // when
        LottoResult result = evaluator.evaluate(purchasedLotteries);

        // then
        assertThat(result.getRankCounts().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.MISS)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("구매 금액과 당첨 결과를 사용하여 수익률을 둘째 자리에서 반올림하여 계산한다")
    @CsvSource({"FIFTH, 8000, 62.5",
            "FIRST, 1000, 200000000",
            "MISS, 8000, 0",
            "FOURTH, 50000, 100",
            "SECOND, 5000, 600000"})
    void 수익률을_계산한다(LottoRank rank, int purchaseAmount, BigDecimal expectedYield) {
        // given
        LottoResult results = new LottoResult();
        results.incrementRankCount(rank);

        // when
        BigDecimal yield = evaluator.calculateYield(results, purchaseAmount);

        // then
        assertThat(yield).isEqualByComparingTo(expectedYield);
    }
}