package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 숫자 6개와 보너스 숫자를 입력할 경우 WinningLotto 객체가 생성된다.")
    void createWinningLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // then
        assertThat(winningLotto).isNotNull();
    }

    @Test
    @DisplayName("당첨 번호 6개 중 보너스 숫자와 일치하는 숫자가 있을 경우 예외가 발생한다.")
    void validateDuplicate() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);
        // when, then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 해당 숫자가 있을 경우 true를 반환한다.")
    void containsLottoNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // when
        boolean result = winningLotto.contains(1);
        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("당첨 번호에 해당 숫자가 있을 경우 false를 반환한다.")
    void notContainsLottoNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // when
        boolean result = winningLotto.contains(45);
        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("보너스 숫자와 입력 숫자가 같을 경우 true를 반환한다.")
    void equalsWithBonus() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // when
        boolean result = winningLotto.equalsWithBonus(7);
        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("보너스 숫자와 입력 숫자가 다를 경우 false를 반환한다.")
    void notEqualsWithBonus() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // when
        boolean result = winningLotto.equalsWithBonus(45);
        // then
        assertThat(result).isFalse();
    }
}