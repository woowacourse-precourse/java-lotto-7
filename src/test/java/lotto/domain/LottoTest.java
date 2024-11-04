package lotto.domain;

import java.util.Arrays;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생해야 한다.")
    void 로또_번호가_범위를_벗어나면_예외가_발생해야_한다() {
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 2, 3, 4, 5, 6); // 0은 범위 밖
        assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    void 로또_번호는_오름차순으로_정렬되어야_한다() {
        List<Integer> unsortedNumbers = Arrays.asList(5, 3, 1, 6, 2, 4);
        Lotto lotto = new Lotto(unsortedNumbers);
        List<Integer> sortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getNumbers()).isEqualTo(sortedNumbers);
    }

    @Test
    @DisplayName("두 로또 객체는 동일한 번호를 가지면 동일한 객체여야 한다.")
    void 두_로또_객체는_동일한_번호를_가지면_동일한_객체여야_한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers);
        assertThat(lotto1).isEqualTo(lotto2);
        assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode());
    }

    @Test
    @DisplayName("두 로또 객체는 다른 번호를 가지면 동일한 객체가 아니어야 한다.")
    void 두_로또_객체는_다른_번호를_가지면_동일한_객체가_아니어야_한다() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(lotto1).isNotEqualTo(lotto2);
    }

    @Test
    @DisplayName("특정 번호가 로또에 포함되어 있으면 true를 반환해야 한다.")
    void 특정_번호가_로또에_포함되어_있으면_true를_반환해야_한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(3)).isTrue();
    }

    @Test
    @DisplayName("특정 번호가 로또에 포함되어 있지 않으면 false를 반환해야 한다.")
    void 특정_번호가_로또에_포함되어_있지_않으면_false를_반환해야_한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(7)).isFalse();
    }

    @Test
    @DisplayName("다른 로또와 일치하는 번호의 개수를 정확하게 반환해야 한다.")
    void 다른_로또와_일치하는_번호의_개수를_정확하게_반환해야_한다() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        int matchCount = lotto1.matchNumber(lotto2.getNumbers());
        assertThat(matchCount).isEqualTo(3);
    }
}