package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 저장된다")
    @Test
    void 로또번호가_오름차순으로_정렬되어_저장된다() {
        // Given
        List<Integer> unorderedNumbers = List.of(45, 12, 23, 8, 34, 2);

        // When
        Lotto lotto = new Lotto(unorderedNumbers);

        // Then
        List<Integer> sortedNumbers = lotto.getNumbers();
        assertThat(sortedNumbers).containsExactly(2, 8, 12, 23, 34, 45);
    }
}
