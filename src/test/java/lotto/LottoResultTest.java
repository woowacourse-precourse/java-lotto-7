package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 수익_계산_테스트() {
        LottoResult lottoResult = new LottoResult();

        int[] result = {1, 3, 0, 0, 2};
        int purchaseAmount = 5000;
        int totalWinnings = (result[0] * 2000000000) + (result[1] * 30000000) + (result[2] * 1500000) + (result[3] * 50000) + (result[4] * 5000);
        double expectProfitRate = (totalWinnings / (double) purchaseAmount) * 100;

        double profitRatio = lottoResult.calculateProfitRate(result, purchaseAmount);

        assertEquals(expectProfitRate, profitRatio, 0.001);
    }
}