package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
    @Test
    void 수익률_계산이_제대로_계산된_경우() {
        LottoResult lottoResult = new LottoResult();
        double profitRate = lottoResult.calculateProfitRate(10000, 5000);

        assertEquals(50.0, profitRate);
    }
}
