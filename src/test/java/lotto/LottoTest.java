package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

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

    @DisplayName("로또 번호의 개수가 6개일 때 예외가 발생하지 않는다.")
    @Test
    void 로또_번호의_개수가_6개일_때_예외가_발생하지_않는다() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> new Lotto(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 1부터 45 사이일 때 예외가 발생하지 않는다.")
    @Test
    void 로또_번호가_1부터_45_사이일_때_예외가_발생하지_않는다() {
        List<Integer> validNumbers = List.of(1, 10, 20, 30, 40, 45);
        assertThatCode(() -> new Lotto(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 클 때 예외가 발생한다.")
    @Test
    void 로또_번호가_1보다_작거나_45보다_클_때_예외가_발생한다() {
        List<Integer> invalidNumbers1 = List.of(0, 2, 3, 4, 5, 6);
        List<Integer> invalidNumbers2 = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(invalidNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(invalidNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
