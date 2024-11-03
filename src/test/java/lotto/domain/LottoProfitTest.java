package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {

    @DisplayName("총 수익률을 계산해서 반환한다.")
    @Test
    void calculateLottoProfit() {
        int lottoMoney = 10000;
        int lottoPrize = 5000;
        float expectedProfit = 50.0f;

        LottoProfit lottoProfit = new LottoProfit(lottoMoney, lottoPrize);

        assertEquals(expectedProfit, lottoProfit.getLottoProfit());
    }
}
