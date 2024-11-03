package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
    @Test
    void 수익률_계산이_제대로_계산된_경우() {
        LottoResult lottoResult = new LottoResult();

        int[] resultCnt = {2, 0, 1, 0, 0};
        int purchaseAmount = 5000;
        int totalWinnings = (resultCnt[0] * 2000000000) + (resultCnt[1] * 30000000) + (resultCnt[2] * 1500000) + (resultCnt[3] * 50000) + (resultCnt[4] * 5000);
        double expectProfitRate = (totalWinnings / (double) purchaseAmount) * 100;

        double profitRate = lottoResult.calculateProfitRate(resultCnt, purchaseAmount);

        assertEquals(expectProfitRate, profitRate, 0.001);
    }
}
