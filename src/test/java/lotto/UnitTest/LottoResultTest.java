package lotto.UnitTest;

import lotto.Model.LottoResult;
import lotto.Model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("당첨 결과에 따른 수익률 계산 테스트 - 62.5% 수익률")
    void testCalculateProfitRate() {
        int purchaseAmount = 8000; // 구입 금액

        // 당첨 결과 설정 (5,000원 당첨 1개)
        List<Rank> ranks = List.of(Rank.FIFTH); // 3개 일치 = 5,000원
        LottoResult lottoResult = new LottoResult(ranks);

        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        assertThat(profitRate).isEqualTo(62.5);
    }

    @Test
    @DisplayName("당첨 결과가 없을 경우 수익률은 0.0%")
    void testCalculateProfitRateNoWinnings() {
        int purchaseAmount = 5000;

        // 당첨 결과가 없는 경우
        List<Rank> ranks = List.of(Rank.MISS); // 당첨 없음
        LottoResult lottoResult = new LottoResult(ranks);

        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        assertThat(profitRate).isEqualTo(0.0);
    }

    @Test
    @DisplayName("여러 당첨 결과에 따른 수익률 계산 테스트")
    void testCalculateProfitRateMultipleWinnings() {
        int purchaseAmount = 10000;

        // 여러 당첨 결과 (5등 2개, 4등 1개)
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH); // 5,000원 2개 + 50,000원 1개
        LottoResult lottoResult = new LottoResult(ranks);

        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        assertThat(profitRate).isEqualTo(600.0); // 총 상금 60,000원 -> 600.0%
    }
}
