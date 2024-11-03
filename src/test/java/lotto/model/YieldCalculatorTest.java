package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.util.LottoRank;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    YieldCalculator yieldCalculator = new YieldCalculator();

    @Test
    void 당첨금에_따른_수익률을_반환한다() {
        int purchaseAmount = 10000;
        int prizeMoney = 55000;
        int lottoCount = 10;
        LottoRank.addMatchLottoCount(3, false);
        LottoRank.addMatchLottoCount(4, false);

        String rateOfReturn = yieldCalculator.calculate(lottoCount);

        double calculatedRateOfReturn = (double) prizeMoney / purchaseAmount * 100;
        String expectedRateOfReturn = String.format("%.1f", calculatedRateOfReturn);

        assertEquals(rateOfReturn, expectedRateOfReturn);
    }

}