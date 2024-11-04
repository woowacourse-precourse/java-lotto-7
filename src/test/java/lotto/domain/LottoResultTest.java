package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoResultTest {

    @DisplayName("각 로또 순위에 맞는 당첨 통계를 계산한다")
    @Test
    void 로또_결과_통계를_계산한다() {
        LottoResult result = new LottoResult();
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.SECOND);
        result.addResult(LottoRank.SECOND);
        result.addResult(LottoRank.THIRD);
        result.addResult(LottoRank.THIRD);
        result.addResult(LottoRank.FOURTH);

        Map<LottoRank, Integer> results = result.getResults();
        assertThat(results.get(LottoRank.FIRST)).isEqualTo(3);
        assertThat(results.get(LottoRank.SECOND)).isEqualTo(2);
        assertThat(results.get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(results.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(results.get(LottoRank.FIFTH)).isNull();
    }

    @DisplayName("구입 금액 대비 총 수익률을 계산한다")
    @Test
    void 총_수익률을_계산한다() {
        LottoResult result = new LottoResult();
        result.addResult(LottoRank.FIRST);
        result.addResult(LottoRank.THIRD);

        int purchaseAmount = 2000;
        double yield = result.calculateYield(purchaseAmount);

        double expectedYield = (LottoRank.FIRST.getPrize() + LottoRank.THIRD.getPrize()) / (double) purchaseAmount * 100; // (당첨금 총합 / 구매 금액)

        assertThat(yield).isEqualTo(expectedYield);
    }

    @DisplayName("다양한 당첨 결과일 때 정확한 수익률 반환")
    @Test
    void 수익률_다양한당첨결과일때_정확한수익률반환() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoRank.FIRST);
        lottoResult.addResult(LottoRank.SECOND);
        lottoResult.addResult(LottoRank.THIRD);

        int purchaseAmount = 2000;
        double yield = lottoResult.calculateYield(purchaseAmount);

        double expectedYield = (LottoRank.FIRST.getPrize() + LottoRank.SECOND.getPrize() + LottoRank.THIRD.getPrize()) / (double) purchaseAmount * 100;
        assertEquals(expectedYield, yield);
    }
}