package lotto;

import lotto.model.calculator.LottoRateCalculator;
import lotto.model.calculator.LottoResultCalculator;
import lotto.model.lottos.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final LottoRateCalculator rateCalculator = new LottoRateCalculator();

    @DisplayName("당첨번호가 없을 때 수익률이 0이어야 한다.")
    @Test
    void 당첨번호가_없을_때_수익률이_0이어야_한다() {
        int price = 10000;
        List<Integer> lottoResult = Arrays.asList(0, 0, 0, 0, 0);
        rateCalculator.calculate(price, lottoResult);
        assertEquals(0.0, rateCalculator.getRate(), 0.01);
    }

    @DisplayName("당첨번호가 있을 때 올바른 수익률을 반환해야 한다.")
    @Test
    void 당첨번호가_있을_때_올바른_수익률을_반환해야_한다() {
        int price = 10000;
        List<Integer> lottoResult = Arrays.asList(1, 1, 1, 1, 1);
        rateCalculator.calculate(price, lottoResult);
        double expectedRate = (2000000000 + 30000000 + 1500000 + 50000 + 5000) / (double) price * 100;
        assertEquals(expectedRate, rateCalculator.getRate(), 0.01);
    }

    private final LottoResultCalculator resultCalculator = new LottoResultCalculator();

    @DisplayName("당첨번호가 모두 일치할 때 1등이 추가되어야 한다.")
    @Test
    void 당첨번호가_모두_일치할_때_1등이_추가되어야_한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        resultCalculator.calculate(winningNumbers, bonusNumber, lottos);
        List<Integer> result = resultCalculator.getResult();

        assertEquals(1, result.get(0));
        assertEquals(0, result.get(1));
        assertEquals(0, result.get(2));
        assertEquals(0, result.get(3));
        assertEquals(0, result.get(4));
    }

    @DisplayName("보너스번호를 가지고 있을 때 2등이 추가되어야 한다.")
    @Test
    void 보너스번호를_가지고_있을_때_2등이_추가되어야_한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))
        );

        resultCalculator.calculate(winningNumbers, bonusNumber, lottos);
        List<Integer> result = resultCalculator.getResult();

        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
        assertEquals(0, result.get(2));
        assertEquals(0, result.get(3));
        assertEquals(0, result.get(4));
    }

    @DisplayName("보너스번호가 없을 때 3등이 추가되어야 한다.")
    @Test
    void 보너스번호가_없을_때_3등이_추가되어야_한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );

        resultCalculator.calculate(winningNumbers, bonusNumber, lottos);
        List<Integer> result = resultCalculator.getResult();

        assertEquals(0, result.get(0));
        assertEquals(0, result.get(1));
        assertEquals(1, result.get(2));
        assertEquals(0, result.get(3));
        assertEquals(0, result.get(4));
    }

    @DisplayName("당첨번호와 일치하지 않는 경우 결과가 변경되지 않아야 한다.")
    @Test
    void 당첨번호와_일치하지_않는_경우_결과가_변경되지_않아야_한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13))
        );

        resultCalculator.calculate(winningNumbers, bonusNumber, lottos);
        List<Integer> result = resultCalculator.getResult();

        assertEquals(0, result.get(0));
        assertEquals(0, result.get(1));
        assertEquals(0, result.get(2));
        assertEquals(0, result.get(3));
        assertEquals(0, result.get(4));
    }
}

