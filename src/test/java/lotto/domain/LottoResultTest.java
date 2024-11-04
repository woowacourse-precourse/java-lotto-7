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

    @DisplayName("모든 등급 당첨 시 정확한 수익률 반환")
    @Test
    void 수익률_모든등급당첨일때_정확한수익률반환() {
        LottoResult lottoResult = new LottoResult();
        for (LottoRank rank : LottoRank.values()) {
            lottoResult.addResult(rank);
        }
        int purchaseAmount = 10000;
        double yield = lottoResult.calculateYield(purchaseAmount);

        double expectedYield = (LottoRank.FIRST.getPrize() +
                LottoRank.SECOND.getPrize() +
                LottoRank.THIRD.getPrize() +
                LottoRank.FOURTH.getPrize() +
                LottoRank.FIFTH.getPrize()) / (double) purchaseAmount * 100;
        assertThat(yield).isEqualTo(expectedYield);
    }

    @DisplayName("로또 번호 0개 일치 시 수익률 0반환")
    @Test
    void 수익률_계산_결과없음_검증() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoRank.NONE);

        int purchaseAmount = 10000;
        double yield = lottoResult.calculateYield(purchaseAmount);

        assertEquals(0, yield);
    }
}