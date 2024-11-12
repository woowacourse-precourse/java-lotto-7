package lotto.view;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
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

    @DisplayName("로또 번호의 범위가 45보다 크면 예외가 발생한다.")
    @Test
    void 로또_번호의_범위가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(4, 6, 8, 10, 55, 1)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호의 범위가 1보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호의_범위가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 올바르면 정상적으로 생성된다")
    void 로또_번호가_올바르면_정상적으로_생성된다() {
        // Given
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = new Lotto(validNumbers);

        // Then
        assertThat(lotto.getNumbers()).isEqualTo(validNumbers);
    }
}
