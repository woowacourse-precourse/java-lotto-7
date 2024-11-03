package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    public void init() {
        lottoResult = new LottoResult(10000000);
    }

    @Test
    void 정상적으로_등수를_추가한다() {
        lottoResult.addRank(LottoRank.FIRST);
        lottoResult.addRank(LottoRank.FIRST);
        lottoResult.addRank(LottoRank.SECOND);

        int firstRankCount = lottoResult.getRankCount(LottoRank.FIRST);
        int secondRankCount = lottoResult.getRankCount(LottoRank.SECOND);
        int thirdRankCount = lottoResult.getRankCount(LottoRank.THIRD);

        assertEquals(2, firstRankCount);
        assertEquals(1, secondRankCount);
        assertEquals(0, thirdRankCount);
    }

    @Test
    void 수익률을_정확하게_계산한다() {
        lottoResult.addRank(LottoRank.SECOND);
        lottoResult.addRank(LottoRank.FIFTH);

        double profitRate = lottoResult.calculateProfitRate();

        long expectedTotalPrize = 30000000 + 5000;
        double expectedProfitRate = ((double) expectedTotalPrize / 10000000) * 100;
        assertEquals(expectedProfitRate, profitRate);
    }


}
