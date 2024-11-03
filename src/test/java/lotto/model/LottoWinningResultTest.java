package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningResultTest {

    @DisplayName("총 수익률을 계산할 수 있다.")
    @Test
    void calculateRateOfReturn() {
        //given
        Map<LottoRank, Integer> lottoRank = new EnumMap<>(LottoRank.class);
        lottoRank.put(LottoRank.FIFTH, 2);
        lottoRank.put(LottoRank.FOURTH, 1);

        LottoWinningResult lottoWinningResult = new LottoWinningResult(lottoRank);
        PurchaseAmount purchaseAmount = PurchaseAmount.from(8000);

        //when
        double rateOfReturn = lottoWinningResult.calculateRateOfReturn(purchaseAmount);

        //then
        assertThat(rateOfReturn).isEqualTo(750.0);
    }
}
