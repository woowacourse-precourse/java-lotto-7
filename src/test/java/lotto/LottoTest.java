package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.MatchResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호와 당첨 번호를 비교해 일치 개수를 확인한다.")
    @Test
    void countMatchingNumber() {
        String enteredWinningNumbers = "1,2,3,4,5,6";
        List<Integer> lottoNumbers = List.of(1,2,3,4,7,9);

        WinningNumber winningNumber = WinningNumber.from(enteredWinningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);

        MatchResult matchResult = lotto.compareWithWinningNumbers(winningNumber, BonusNumber.from("10", winningNumber));
        int actualMatchCount = matchResult.matchCount();

        Assertions.assertThat(actualMatchCount).isEqualTo(4);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교해 보너스 번호 포함 여부를 확인한다.")
    @Test
    void containsBonusNumber() {
        String enteredBonusNumber = "7";
        List<Integer> lottoNumbers = List.of(1,2,3,4,7,9);

        WinningNumber winningNumber = WinningNumber.from("10,11,12,13,14,15");
        BonusNumber bonusNumber = BonusNumber.from(enteredBonusNumber, winningNumber);
        Lotto lotto = new Lotto(lottoNumbers);

        MatchResult matchResult = lotto.compareWithWinningNumbers(winningNumber, bonusNumber);
        boolean actualContainsBonusNumber = matchResult.containBonusNumber();

        Assertions.assertThat(actualContainsBonusNumber).isEqualTo(true);
    }
}
