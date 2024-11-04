package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void validateDuplicateBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void validateBonusNumberRange() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 번호의 개수를 반환한다")
    @Test
    void matchNumbers() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(winningLotto.matchNumbers(lotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호와 일치하는지 확인한다")
    @Test
    void matchBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winningLotto.hasBonusNumber(lotto)).isTrue();
    }
}
