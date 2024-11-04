package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("당첨 결과에 따른 당첨금 합계 테스트")
    @Test
    void totalPrizeTest() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.THIRD, Rank.FIFTH);
        LottoResult result = LottoResult.createResult(ranks);
        assertThat(result.getTotalPrize()).isEqualTo(2_001_505_000);
    }

    @DisplayName("당첨 결과에 따른 수익률 테스트")
    @Test
    void revenueRateTest() {
        List<Rank> ranks = List.of(Rank.FIFTH);
        LottoResult result = LottoResult.createResult(ranks);
        int payment = 8000;
        assertThat(result.calculateRevenueRate(payment)).isEqualTo(62.5);
    }

}