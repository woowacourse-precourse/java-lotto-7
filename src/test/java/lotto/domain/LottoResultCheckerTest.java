package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultCheckerTest {
    @DisplayName("로또 번화와 당첨 번호를 비교하여 일치하는 숫자 개수를 구한다.")
    @Test
    void 로또_번화와_당첨_번호를_비교하여_일치하는_숫자_개수를_구한다(){
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,3,5,7,9,11));
        WinningNumbers winningNumbers = WinningNumbers.from(Arrays.asList(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        DrawnNumbers drawnNumbers = new DrawnNumbers(winningNumbers,bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(drawnNumbers);

        // when
        int matchCount = lottoResultChecker.calculateMatchCount(lotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }
}