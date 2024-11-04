package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoProfitRateCalculator.calculateProfitRate;
import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitRateCalculatorTest {
    @DisplayName("수익률을 구한다")
    @Test
    void 수익률을_구한다() {
        // given
        // 테스트 상태 5등 당첨
        final String COST = "2000";
        final List<Integer> LOTTO_NUMBERS_1 = Arrays.asList(1, 3, 5, 7, 9, 11);
        final List<Integer> LOTTO_NUMBERS_2 = Arrays.asList(21, 22, 23, 24, 25, 26);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
        final String BONUS_NUMBER = "45";

        Cost cost = new Cost(COST);
        Lotto lotto1 = new Lotto(LOTTO_NUMBERS_1);
        Lotto lotto2 = new Lotto(LOTTO_NUMBERS_2);
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers, bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);
        WinningResult winningResult = lottoResultChecker.check(lottos);

        // when
        double profitRate = calculateProfitRate(cost, winningResult);

        // then
        assertThat(profitRate).isEqualTo(250.0);
    }
}