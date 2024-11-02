package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    //추가 테스트코드
    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호와 주어진 당첨번호를 비교하여 맞은개수를 반환한다.")
    @Test
    void countMatchingNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> winningNumbers = List.of(4, 5, 6, 7, 8, 9);

        // when
        int matchCount = lotto.countMatchingNumbers(winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("보너스번호가 로또번호에 존재한다면 true를 반환한다.")
    @Test
    void containsBonusNumber_true() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        int bonusNumber = 1;

        // when
        boolean hasBonus = lotto.containsBonusNumber(bonusNumber);

        // then
        assertThat(hasBonus).isTrue();
    }

    @DisplayName("보너스번호가 로또번호에 존재하지 않는다면 false를 반환한다.")
    @Test
    void containsBonusNumber_false() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        int bonusNumber = 7;

        // when
        boolean hasBonus = lotto.containsBonusNumber(bonusNumber);

        // then
        assertThat(hasBonus).isFalse();
    }

}
