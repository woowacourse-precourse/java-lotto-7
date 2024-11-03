package lotto.domain.WinningLotto;

import lotto.domain.LottoFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningLottoCalculateTest {

    private WinningLottoCounter winningLottoCounter;
    private LottoFormatter lottoFormatter;
    private WinningLottoCalculate winningLottoCalculate;

    @BeforeEach
    void setup() {
        winningLottoCounter = new WinningLottoCounter();
        lottoFormatter = new LottoFormatter(winningLottoCounter);
        winningLottoCalculate = new WinningLottoCalculate(winningLottoCounter, lottoFormatter);
    }

    @Test
    void 로또_구매_개수_계산() {
        int buyLottoMoney = 1000;
        int expectedCount = 1;
        int actualCount = winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);

        buyLottoMoney = 5000;
        expectedCount = 5;
        actualCount = winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);

        buyLottoMoney = 0;
        expectedCount = 0;
        actualCount = winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);

        buyLottoMoney = 3500;
        expectedCount = 3;
        actualCount = winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    void 로또_수익률_계산() {
        int buyLottoMoney = 1000;

        winningLottoCounter.incrementCount(WinningLotto.THREE_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.THREE_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.FIVE_MATCH);
        winningLottoCounter.incrementCount(WinningLotto.SIX_MATCH);

        long expectedTotalPrize = (2 * 5000L) + 1500000L + 2000000000L;

        double rawRateOfReturn = ((double) expectedTotalPrize / buyLottoMoney) * 100.0;
        double expectedRateOfReturn = lottoFormatter.formatRounding(rawRateOfReturn);

        double rateOfReturn = winningLottoCalculate.calculateLottoRateOfReturn(buyLottoMoney);

        Assertions.assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }
}