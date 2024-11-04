package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsCalculatorTest {
    private LottoStatisticsCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new LottoStatisticsCalculator();
    }

    @Test
    void 당첨_등수_및_수익률이_예상한대로_나오면_성공한다() {
        // given
        Map<Lotto, LottoRank> lottoRankResults = new HashMap<>();
        lottoRankResults.put(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.SIX_MATCH);
        lottoRankResults.put(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRank.FIVE_MATCH_BONUS);
        lottoRankResults.put(new Lotto(List.of(1, 2, 3, 4, 5, 8)), LottoRank.FIVE_MATCH);
        lottoRankResults.put(new Lotto(List.of(1, 2, 3, 4, 10, 11)), LottoRank.FOUR_MATCH);

        int buyAmount = 4000;

        Map<LottoRank, Integer> expectedRankCounts = Map.of(
                LottoRank.SIX_MATCH, 1,
                LottoRank.FIVE_MATCH_BONUS, 1,
                LottoRank.FIVE_MATCH, 1,
                LottoRank.FOUR_MATCH, 1,
                LottoRank.THREE_MATCH, 0,
                LottoRank.MISS, 0
        );
        long expectedTotalPrize = LottoRank.SIX_MATCH.getPrize() +
                LottoRank.FIVE_MATCH_BONUS.getPrize() +
                LottoRank.FIVE_MATCH.getPrize() +
                LottoRank.FOUR_MATCH.getPrize();

        double expectedProfitRate = ((double) expectedTotalPrize / buyAmount) * 100;
        expectedProfitRate = Math.round(expectedProfitRate * 100) / 100.0;

        //when
        LottoResult result = calculator.calculateStatistic(lottoRankResults, buyAmount);

        //then
        Assertions.assertThat(result.getRankCounts()).isEqualTo(expectedRankCounts);
        Assertions.assertThat(result.getTotalPrize()).isEqualTo(expectedTotalPrize);
        Assertions.assertThat(result.getProfitRate()).isEqualTo(expectedProfitRate);
    }
    @Test
    void 당첨_등수_및_수익률이_예상한대로_나오면_성공한다2() {
        // given
        Map<Lotto, LottoRank> lottoRankResults = new HashMap<>();
        lottoRankResults.put(new Lotto(List.of(1, 2, 42, 43, 44, 45)), LottoRank.MISS);
        lottoRankResults.put(new Lotto(List.of(1, 2, 42, 43, 44, 45)), LottoRank.MISS);
        lottoRankResults.put(new Lotto(List.of(1, 2, 3, 4, 10, 11)), LottoRank.FOUR_MATCH);

        int buyAmount = 3000;

        Map<LottoRank, Integer> expectedRankCounts = Map.of(
                LottoRank.SIX_MATCH, 0,
                LottoRank.FIVE_MATCH_BONUS, 0,
                LottoRank.FIVE_MATCH, 0,
                LottoRank.FOUR_MATCH, 1,
                LottoRank.THREE_MATCH, 0,
                LottoRank.MISS, 2
        );
        long expectedTotalPrize = LottoRank.FOUR_MATCH.getPrize();

        double expectedProfitRate = ((double) expectedTotalPrize / buyAmount) * 100;
        expectedProfitRate = Math.round(expectedProfitRate * 100) / 100.0;

        //when
        LottoResult result = calculator.calculateStatistic(lottoRankResults, buyAmount);

        //then
        Assertions.assertThat(result.getRankCounts()).isEqualTo(expectedRankCounts);
        Assertions.assertThat(result.getTotalPrize()).isEqualTo(expectedTotalPrize);
        Assertions.assertThat(result.getProfitRate()).isEqualTo(expectedProfitRate);
    }
}
