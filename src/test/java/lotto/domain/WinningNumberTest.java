package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void createWinningNumberWithDuplicateBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        
        assertThatThrownBy(() -> new WinningNumber(winningLotto, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 반환한다")
    @Test
    void countMatchingNumbers() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(winningLotto, 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        
        assertThat(winningNumber.matchCount(userLotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치 여부를 확인한다")
    @Test
    void checkBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(winningLotto, 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        
        assertThat(winningNumber.hasBonusNumber(userLotto)).isTrue();
    }
}