package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호와 당첨 번호 간 일치하는 개수를 올바르게 반환한다.")
    @Test
    void matchCount_ShouldReturnCorrectCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(3, 4, 5, 6, 7, 8);

        int matchCount = lotto.matchCount(winningNumbers);

        assertThat(matchCount).isEqualTo(4); // 3, 4, 5, 6이 일치
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되는지 확인한다.")
    @Test
    void isBonusMatched_ShouldReturnTrueIfBonusNumberIsMatched() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        boolean isBonusMatched = lotto.isBonusMatched(bonusNumber);

        assertThat(isBonusMatched).isTrue();
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되지 않으면 false를 반환한다.")
    @Test
    void isBonusMatched_ShouldReturnFalseIfBonusNumberIsNotMatched() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        boolean isBonusMatched = lotto.isBonusMatched(bonusNumber);

        assertThat(isBonusMatched).isFalse();
    }

}
