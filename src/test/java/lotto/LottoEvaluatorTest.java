package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThat(result.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.MISS)).isEqualTo(0);
    }
}