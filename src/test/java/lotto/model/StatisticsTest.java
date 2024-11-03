package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("당첨 결과가 올바르게 계산된다.")
        void createStatistics() {
            // given
            List<Rank> ranks = List.of(
                    Rank.FIRST_PLACE,
                    Rank.SECOND_PLACE,
                    Rank.FIFTH_PLACE,
                    Rank.FIFTH_PLACE,
                    Rank.NO_WIN
            );

            // when
            Statistics statistics = new Statistics(ranks);
            Map<Rank, Integer> winningResult = statistics.getWinningResult();

            // then
            assertSoftly(softly -> {
                softly.assertThat(winningResult.get(Rank.FIRST_PLACE)).isEqualTo(1);
                softly.assertThat(winningResult.get(Rank.SECOND_PLACE)).isEqualTo(1);
                softly.assertThat(winningResult.get(Rank.FIFTH_PLACE)).isEqualTo(2);
                softly.assertThat(winningResult.get(Rank.NO_WIN)).isEqualTo(1);
            });
        }

        @Test
        @DisplayName("당첨이 없는 경우, 수익률은 0이다.")
        void createStatisticsWithNoWin() {
            // given
            List<Rank> ranks = List.of(
                    Rank.NO_WIN,
                    Rank.NO_WIN,
                    Rank.NO_WIN
            );

            // when
            Statistics statistics = new Statistics(ranks);

            // then
            assertThat(statistics.getYield()).isEqualTo(BigDecimal.ZERO);
        }

        @Test
        @DisplayName("정확한 수익률을 계산한다.")
        void calculateExactYield() {
            // given
            List<Rank> ranks = List.of(
                    Rank.FIRST_PLACE,
                    Rank.FOURTH_PLACE
            );
            BigDecimal expectedTotalPrize = BigDecimal.valueOf(
                    Rank.FIRST_PLACE.getPrize() + Rank.FOURTH_PLACE.getPrize());
            BigDecimal expectedPurchaseAmount = BigDecimal.valueOf(Money.fromLottoCount(ranks.size()).getAmount());
            BigDecimal expectedYield = expectedTotalPrize
                    .multiply(BigDecimal.valueOf(100))
                    .divide(expectedPurchaseAmount, 1, RoundingMode.HALF_UP);

            // when
            Statistics statistics = new Statistics(ranks);

            // then
            assertThat(statistics.getYield()).isEqualTo(expectedYield);
        }
    }
}
