package lotto.domain;

import static lotto.domain.constants.LottoConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import lotto.domain.vo.LottoRank;
import org.junit.jupiter.api.Test;

class LottoResultTests {
    @Test
    void testGetCountByRankReturnsCorrectCount() {
        EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        rankCounts.put(LottoRank.FIRST, 1);
        rankCounts.put(LottoRank.SECOND, 2);

        LottoResult lottoResult = LottoResult.of(rankCounts);

        assertThat(lottoResult.getCountByRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getCountByRank(LottoRank.SECOND)).isEqualTo(2);
        assertThat(lottoResult.getCountByRank(LottoRank.THIRD)).isEqualTo(0);
    }

    @Test
    void testCalculateProfitRateReturnsCorrectRate() {
        EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        rankCounts.put(LottoRank.FIRST, 1); // 1등 1개
        rankCounts.put(LottoRank.THIRD, 2); // 3등 2개

        LottoResult lottoResult = LottoResult.of(rankCounts);
        int purchaseAmount = LOTTO_PRICE * 5;

        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);

        long expectedPrize = LottoRank.FIRST.getPrize() + (LottoRank.THIRD.getPrize() * 2);
        double expectedRate = (expectedPrize / (double) purchaseAmount) * 100;
        double roundedExpectedRate = Math.round(expectedRate * 10.0) / 10.0;

        assertThat(profitRate).isEqualTo(roundedExpectedRate);
    }

    @Test
    void testCalculateProfitRateReturnsZeroWhenNoWinnings() {
        EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

        LottoResult lottoResult = LottoResult.of(rankCounts);
        int purchaseAmount = LOTTO_PRICE * 10;

        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(0.0);
    }
}