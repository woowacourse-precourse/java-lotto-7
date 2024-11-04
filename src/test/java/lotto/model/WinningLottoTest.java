package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 객체가 정상적으로 생성된다")
    void createWinningLotto() {
        // given
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // when, then
        assertDoesNotThrow(() -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    void validateDuplicateBonusNumber() {
        // given
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        // when, then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
    }

    @Test
    @DisplayName("구매한 로또와 당첨 번호를 비교하여 일치하는 번호의 개수를 반환한다")
    void countMatchedNumber() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );
        Lotto purchasedLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        int matchCount = winningLotto.countMatchedLottoNumber(purchasedLotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("구매한 로또에 보너스 번호가 포함되어 있는지 확인한다")
    void isMatchBonusNumber() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );
        Lotto purchasedLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        boolean isMatch = winningLotto.isMatchBonusNumber(purchasedLotto);

        // then
        assertThat(isMatch).isTrue();
    }
}
