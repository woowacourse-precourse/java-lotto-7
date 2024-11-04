package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.WinningType.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {
    @DisplayName("당첨 여부를 판단하고 당첨 내역을 업데이트 한다")
    @Test
    void 당첨_여부를_판단하고_당첨_내역을_업데이트_한다() {
        // given
        final List<Integer> LOTTO_NUMBERS_1 = Arrays.asList(1, 3, 5, 7, 9, 11);
        final List<Integer> LOTTO_NUMBERS_2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
        final String BONUS_NUMBER = "7";

        Lotto lotto1 = new Lotto(LOTTO_NUMBERS_1);
        Lotto lotto2 = new Lotto(LOTTO_NUMBERS_2);
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers, bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        WinningResult winningResult = lottoResultChecker.check(lottos);

        // then
        assertThat(winningResult.getWinningResult().get(FIFTH)).isEqualTo(1);
        assertThat(winningResult.getWinningResult().get(FIRST)).isEqualTo(1);
    }

    @DisplayName("로또 번호에서 보너스 번호와 일치하는 여부를 구한다. - 일치하는 경우")
    @Test
    void 로또_번호에서_보너스_번호와_일치하는_여부를_구한다() {
        // given
        final List<Integer> LOTTO_NUMBERS_1 = Arrays.asList(1, 2, 3, 4, 5, 7);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 8);
        final String BONUS_NUMBER = "7";

        Lotto lotto1 = new Lotto(LOTTO_NUMBERS_1);
        Lottos lottos = new Lottos(Arrays.asList(lotto1));

        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers, bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        WinningResult winningResult = lottoResultChecker.check(lottos);

        // then
        assertThat(winningResult.getWinningResult().get(SECOND)).isEqualTo(1);
    }

    @DisplayName("로또 번호에서 보너스 번호와 일치하는 여부를 구한다. - 일치하지 않는 경우")
    @Test
    void 로또_번호에서_보너스_번호와_일치하는_여부를_구한다2() {
        // given
        final List<Integer> LOTTO_NUMBERS_1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 8);
        final String BONUS_NUMBER = "7";

        Lotto lotto1 = new Lotto(LOTTO_NUMBERS_1);
        Lottos lottos = new Lottos(Arrays.asList(lotto1));

        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers, bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        WinningResult winningResult = lottoResultChecker.check(lottos);

        // then
        assertThat(winningResult.getWinningResult().get(THIRD)).isEqualTo(1);
    }
}