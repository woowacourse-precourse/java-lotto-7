package lotto;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        // 주어진 로또 결과를 기반으로 LottoResult 초기화
        Map<LottoRanking, Integer> results = new HashMap<>();
        results.put(LottoRanking.FIFTH, 2);  // 2개의 5등
        results.put(LottoRanking.FOURTH, 1); // 1개의 4등
        results.put(LottoRanking.THIRD, 0);  // 0개의 3등
        results.put(LottoRanking.SECOND, 1); // 0개의 2등
        results.put(LottoRanking.FIRST, 0);  // 1개의 1등

        lottoResult = new LottoResult(results);
    }

    @DisplayName("당첨 결과가 있으면 누적 당첨금을 계산한다")
    @Test
    void 당첨_결과가_있을때() {
        // When
        int totalPrize = lottoResult.calculateTotalPrize();

        // Then
        int expectedTotalPrize = (2 * 5_000) + (1 * 50_000) + (1 * 30_000_000);
        Assertions.assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }

    @DisplayName("당첨 결과가 없으면 누적 당첨금은 0원이다.")
    @Test
    void 당첨_결과가_없을때() {
        // Given: 당첨 결과가 없는 LottoResult 생성
        Map<LottoRanking, Integer> emptyResults = new HashMap<>();
        LottoResult emptyLottoResult = new LottoResult(emptyResults);

        // When
        int totalPrize = emptyLottoResult.calculateTotalPrize();

        // Then
        Assertions.assertThat(totalPrize).isEqualTo(0);
    }

    @DisplayName("당첨 결과를 토대로 수익률을 계산한다")
    @Test
    void 수익률_계산() {
        // given
        int purchaseAmount = 100_000;

        // when
        double profitRate = lottoResult.calculateProfit(purchaseAmount);
        int totalPrize = (2 * 5_000) + (1 * 50_000) + (1 * 30_000_000);
        double expectedProfitRate = (double) totalPrize / purchaseAmount * 100;

        // then
        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
