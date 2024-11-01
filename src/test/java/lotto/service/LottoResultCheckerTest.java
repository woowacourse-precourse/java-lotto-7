package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultCheckerTest {
    @Test
    @DisplayName("6개 번호가 모두 일치하면 1등이어야 한다.")
    void 모든_번호_일치_1등() {
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 42));
        WinningNumbers winningNumbers = new WinningNumbers("8, 21, 15, 33, 40, 42");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());

        LottoResultChecker checker = new LottoResultChecker();
        WinningResult result = checker.checkResult(lotto, winningNumbers, bonusNumber);

        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이어야 한다.")
    void 다섯_번호_보너스_일치_2등() {
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 7));
        WinningNumbers winningNumbers = new WinningNumbers("8, 21, 15, 33, 40, 42");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());

        LottoResultChecker checker = new LottoResultChecker();
        WinningResult result = checker.checkResult(lotto, winningNumbers, bonusNumber);

        assertThat(result.getRank()).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치하면 3등이어야 한다.")
    void 다섯_번호_일치_3등() {
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 43));
        WinningNumbers winningNumbers = new WinningNumbers("8, 21, 15, 33, 40, 42");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());

        LottoResultChecker checker = new LottoResultChecker();
        WinningResult result = checker.checkResult(lotto, winningNumbers, bonusNumber);

        assertThat(result.getRank()).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 번호가 일치하면 4등이어야 한다.")
    void 네_번호_일치_4등() {
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 44, 45));
        WinningNumbers winningNumbers = new WinningNumbers("8, 21, 15, 33, 40, 42");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());

        LottoResultChecker checker = new LottoResultChecker();
        WinningResult result = checker.checkResult(lotto, winningNumbers, bonusNumber);

        assertThat(result.getRank()).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 번호가 일치하면 5등이어야 한다.")
    void 세_번호_일치_5등() {
        Lotto lotto = new Lotto(List.of(8, 21, 15, 34, 44, 45));
        WinningNumbers winningNumbers = new WinningNumbers("8, 21, 15, 33, 40, 42");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());

        LottoResultChecker checker = new LottoResultChecker();
        WinningResult result = checker.checkResult(lotto, winningNumbers, bonusNumber);

        assertThat(result.getRank()).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하의 번호가 일치하면 당첨되지 않는다.")
    void 두_번호_이하_일치_꽝() {
        Lotto lotto = new Lotto(List.of(8, 21, 16, 34, 44, 45));
        WinningNumbers winningNumbers = new WinningNumbers("8, 21, 15, 33, 40, 42");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());

        LottoResultChecker checker = new LottoResultChecker();
        WinningResult result = checker.checkResult(lotto, winningNumbers, bonusNumber);

        assertThat(result.getRank()).isEqualTo(Rank.NO_WIN);
    }
}
