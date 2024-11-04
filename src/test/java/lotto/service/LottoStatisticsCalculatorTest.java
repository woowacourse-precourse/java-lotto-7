package lotto.service;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottoStatisticsCalculatorTest {

    @Test
    @DisplayName("로또 결과를 기반으로 등수별 개수 계산 테스트")
    void 로또_결과를_기반으로_등수별_개수_계산_테스트() {
        // given
        List<LottoResult> results = List.of(
                new LottoResult(3, false),  // 3개 일치
                new LottoResult(3, false),  // 3개 일치
                new LottoResult(4, false),  // 4개 일치
                new LottoResult(5, true),   // 5개 일치 + 보너스
                new LottoResult(6, false)   // 6개 일치
        );

        // when
        Map<LottoRank, Long> rankCounts = LottoStatisticsCalculator.calculateRankCounts(results);

        // then
        assertEquals(2L, rankCounts.getOrDefault(LottoRank.THREE_MATCHES, 0L)); // 3개 일치: 2번
        assertEquals(1L, rankCounts.getOrDefault(LottoRank.FOUR_MATCHES, 0L)); // 4개 일치: 1번
        assertEquals(1L, rankCounts.getOrDefault(LottoRank.FIVE_MATCHES_WITH_BONUS, 0L)); // 5개 일치 + 보너스: 1번
        assertEquals(1L, rankCounts.getOrDefault(LottoRank.SIX_MATCHES, 0L)); // 6개 일치: 1번
        assertEquals(0L, rankCounts.getOrDefault(LottoRank.FIVE_MATCHES, 0L)); // 5개 일치: 0번
    }

    @Test
    @DisplayName("총 수익률 계산 테스트")
    void 총_수익률_계산_테스트() {
        // given
        Map<LottoRank, Long> rankCounts = Map.of(
                LottoRank.THREE_MATCHES, 1L
        );
        int purchaseAmount = 8000;

        // when
        double profitRate = LottoStatisticsCalculator.calculateProfitRate(rankCounts, purchaseAmount);

        // then
        assertEquals(62.5, profitRate);
    }
}
