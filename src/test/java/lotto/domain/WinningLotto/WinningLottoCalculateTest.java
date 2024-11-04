package lotto.domain.WinningLotto;

import lotto.formatter.LottoFormatter;
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
        int buyLottoMoney = 3000;
        int expectedCount = 3;

        int actualCount = winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);

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

    @Test
    void 로또_구입_금액_단위_예외_테스트() {
        int buyLottoMoney = 1020;

        Assertions.assertThatThrownBy(() -> {
                    winningLottoCalculate.calculateBuyLottoCount(buyLottoMoney);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1,000 단위여야 합니다.");
    }
}
