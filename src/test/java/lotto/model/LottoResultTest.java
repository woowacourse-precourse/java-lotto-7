package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    public void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("50000원을 지출해서 2등 당첨 시 수익률 계산 확인")
    public void 수익률_계산_확인() {
        // given
        lottoResult.addRank(LottoRank.SECOND);
        int totalSpent = 50000;

        // when
        double profitRate = lottoResult.calculateProfitRate(totalSpent);

        // then
        int expectedTotalPrize = LottoRank.SECOND.getPrize();
        double expectedProfitRate = (expectedTotalPrize / (double) totalSpent) * 100;

        assertEquals(expectedProfitRate, profitRate);
    }
}
