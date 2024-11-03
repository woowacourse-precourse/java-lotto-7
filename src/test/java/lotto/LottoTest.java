package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호가_6개를_넘으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정해진 시작 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_시작_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 중복되는 번호를 가지고 있으면 true 반환한다.")
    @Test
    void 로또_번호와_중복되는_번호가_있으면_true_반환한다() {
        int number = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), 7);
        boolean result = lotto.contains(number);
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호와 중복되는 번호가 없으면 false 반환한다.")
    @Test
    void 로또_번호와_중복되는_번호가_없으면_false_반환한다() {
        int number = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), 7);
        boolean result = lotto.contains(number);
        assertThat(result).isFalse();
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("무작위 로또 번호 생성이 잘 작동하는지 확인한다.")
    @Test
    void 무작위_로또_번호_생성이_잘_작동하는지_확인한다() {
        Lotto lotto = Lotto.generateRandomLotto();
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = lotto.getBonusNumber();

        // 생성된 번호의 개수가 6개인지 확인
        assertThat(numbers).hasSize(6);

        // 중복 검사
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers.size()).isEqualTo(numbers.size());

        // 모든 번호가 1부터 45 사이인지 확인
        for (int number : numbers) {
            assertThat(number).isBetween(1, 45);
        }

        // 보너스 번호 확인
        assertThat(bonusNumber).isBetween(1, 45);
        assertThat(numbers).doesNotContain(bonusNumber); // 보너스 번호는 로또 번호에 포함되지 않아야 함
    }
}
