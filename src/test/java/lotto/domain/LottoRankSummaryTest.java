package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankSummaryTest {
    @Test
    void 수익률을_계산한다() {
        LottoRankSummary lottoRankSummary = new LottoRankSummary();
        lottoRankSummary.incrementCount(LottoRank.FIFTH_RANK);
        Budget budget = new Budget(8000);

        double rateOfReturn = lottoRankSummary.calculateRateOfReturn(budget);

        assertEquals(62.5, rateOfReturn);
    }
}
