package lotto.model;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRevenueCalculatorTest {

    @Test
    @DisplayName("수익률이 0퍼센트 일때")
    void 수익률이_0퍼센트_일때() {
        Map<LottoRank, Integer> lottoResult = Map.of(
                LottoRank.FIFTH, 0,
                LottoRank.FOURTH, 0,
                LottoRank.THIRD, 0,
                LottoRank.SECOND, 0,
                LottoRank.FIRST, 0
        );
        int moneySpent = 1000;

        LottoRevenueCalculator lottoRevenueCalculator = LottoRevenueCalculator.of(lottoResult, moneySpent);

        Assertions.assertEquals(0.0, lottoRevenueCalculator.calculateRevenue());
    }

    @Test
    @DisplayName("수익률이 있을때")
    void 수익률이_있을때() {
        Map<LottoRank, Integer> lottoResult = Map.of(
                LottoRank.FIFTH, 1,
                LottoRank.FOURTH, 1,
                LottoRank.THIRD, 0,
                LottoRank.SECOND, 0,
                LottoRank.FIRST, 0
        );
        int moneySpent = 3000;

        LottoRevenueCalculator lottoRevenueCalculator = LottoRevenueCalculator.of(lottoResult, moneySpent);

        Assertions.assertEquals(1833.3, lottoRevenueCalculator.calculateRevenue(), 0.1);
    }

    @Test
    @DisplayName("수익률이 100퍼센트 일때")
    void 수익률이_100퍼센트_일때() {
        Map<LottoRank, Integer> lottoResult = Map.of(
                LottoRank.FIFTH, 1,
                LottoRank.FOURTH, 0,
                LottoRank.THIRD, 0,
                LottoRank.SECOND, 0,
                LottoRank.FIRST, 0
        );
        int moneySpent = 5000;

        LottoRevenueCalculator lottoRevenueCalculator = LottoRevenueCalculator.of(lottoResult, moneySpent);

        Assertions.assertEquals(100, lottoRevenueCalculator.calculateRevenue());
    }
}
