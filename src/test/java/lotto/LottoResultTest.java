package lotto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult = new LottoResult();

    @Test
    void constructorTest() {
        for (LottoRank rank : LottoRank.values()) {
            assertThat(lottoResult.getCountForRank(rank)).isZero();
        }
    }

    @Test
    void calculateReturnRateTest() {
        lottoResult.addResult(LottoRank.FIFTH);
        lottoResult.addResult(LottoRank.THIRD);
        int purchaseAmount = 14000;

        double expectedReturnRate = ((5000 + 1500000) * 100.0) / purchaseAmount;
        assertThat(lottoResult.calculateReturnRate(purchaseAmount)).isEqualTo(expectedReturnRate);
    }

    @Test
    void calculateReturnRateZeroTest() {
        int purchaseAmount = 5000;  // 5장 구매
        assertThat(lottoResult.calculateReturnRate(purchaseAmount)).isZero();
    }
}