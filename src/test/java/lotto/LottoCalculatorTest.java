package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoNumberCounter;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoCalculatorTest {

    @Test
    @DisplayName("로또 결과를 정확히 계산한다.")
    void calculateLottoResults() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        Lottos purchasedLottos = new Lottos(lottos);

        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(winningNumbersSet);

        BonusNumber bonusNumber = new BonusNumber(7);

        LottoCalculator calculator = new LottoCalculator(purchasedLottos, bonusNumber, winningNumber);

        List<LottoNumberCounter> counters = calculator.calculateMatching();
        int[] results = calculator.getLottoResult(counters);

        assertThat(results[4]).isEqualTo(1);
        assertThat(results[0]).isEqualTo(1);
        assertThat(results[1]).isEqualTo(0);
        assertThat(results[2]).isEqualTo(0);
        assertThat(results[3]).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률을 정확히 계산한다.")
    void calculateProfitRateCorrectly() {
        // Given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        Lottos purchasedLottos = new Lottos(lottos);

        Set<Integer> winningNumbersSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(winningNumbersSet);

        BonusNumber bonusNumber = new BonusNumber(7);

        LottoCalculator calculator = new LottoCalculator(purchasedLottos, bonusNumber, winningNumber);

        List<LottoNumberCounter> counters = calculator.calculateMatching();
        int[] results = calculator.getLottoResult(counters);

        LottoAmount lottoAmount = new LottoAmount(3);

        double profitRate = calculator.calculateProfitRate(results, lottoAmount);

        double expectedProfit = 2000000000.0 + 5000.0;
        double totalCost = 3000.0;
        double expectedProfitRate = (expectedProfit / totalCost) * 100.0;
        expectedProfitRate = Math.round(expectedProfitRate * 100.0) / 100.0;

        assertThat(Math.round(profitRate * 100) / 100.0)
                .isEqualTo(Math.round(expectedProfitRate * 100) / 100.0);
    }
}
