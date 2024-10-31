package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankSummaryTest {
    @Test
    void 수익률을_계산한다() {
        LottoRankSummary lottoRankSummary = new LottoRankSummary();
        lottoRankSummary.incrementCount(LottoRank.FIFTH_RANK);
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");

        double rateOfReturn = lottoRankSummary.calculateRateOfReturn(purchaseAmount);

        assertEquals(62.5, rateOfReturn);
    }
}
