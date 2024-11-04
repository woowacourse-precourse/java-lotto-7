package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultCheckerTest {
    @DisplayName("로또 번화와 당첨 번호를 비교하여 일치하는 숫자 개수를 구한다.")
    @Test
    void 로또_번화와_당첨_번호를_비교하여_일치하는_숫자_개수를_구한다(){
        // given
        final List<Integer> LOTTO_NUMBERS = Arrays.asList(1,3,5,7,9,11);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,4,5,6);
        final String BONUS_NUMBER = "7";

        Lotto lotto = new Lotto(LOTTO_NUMBERS);
        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers,bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        int matchCount = lottoResultChecker.calculateMatchCount(lotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("로또 번호에서 보너스 번호와 일치하는 여부를 구한다. - 일치하는 경우")
    @Test
    void 로또_번호에서_보너스_번호와_일치하는_여부를_구한다(){
        // given
        final List<Integer> LOTTO_NUMBERS = Arrays.asList(1,3,5,7,9,11);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,4,5,6);
        final String BONUS_NUMBER = "7";

        Lotto lotto = new Lotto(LOTTO_NUMBERS);
        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers,bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        boolean bonusMatch = lottoResultChecker.hasBonusMatch(lotto);

        // then
        assertThat(bonusMatch).isEqualTo(true);
    }

    @DisplayName("로또 번호에서 보너스 번호와 일치하는 여부를 구한다. - 일치하지 않는 경우")
    @Test
    void 로또_번호에서_보너스_번호와_일치하는_여부를_구한다2(){
        // given
        final List<Integer> LOTTO_NUMBERS = Arrays.asList(1,3,5,7,9,11);
        final List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,4,5,6);
        final String BONUS_NUMBER = "8";

        Lotto lotto = new Lotto(LOTTO_NUMBERS);
        WinningNumbers winningNumbers = WinningNumbers.from(WINNING_NUMBERS);
        BonusNumber bonusNumber = new BonusNumber(BONUS_NUMBER, winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers,bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        boolean bonusMatch = lottoResultChecker.hasBonusMatch(lotto);

        // then
        assertThat(bonusMatch).isEqualTo(false);
    }
}