package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또번호가_범위를_벗어나면_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("올바른 로또 번호로 Lotto 객체를 생성할 수 있다.")
    @Test
    void 올바른_로또번호로_Lotto객체_생성() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
    }

    @DisplayName("로또 번호와 당첨 번호의 일치 개수를 올바르게 계산한다.")
    @Test
    void 로또번호와_당첨번호의_일치개수_계산() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 7, 8, 9);
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 확인한다.")
    @Test
    void 로또번호에_보너스번호_포함여부_확인() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        boolean containsBonus = lotto.containsNumber(7);
        assertThat(containsBonus).isTrue();

        containsBonus = lotto.containsNumber(13);
        assertThat(containsBonus).isFalse();
    }
}
