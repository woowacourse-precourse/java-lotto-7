package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호의 개수가 6개가 아닌 경우 예외가 발생한다")
    @Test
    void 로또_번호의_개수가_6개가_미만인_경우_예외가_발생한다() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 큰 경우 예외가 발생한다")
    @Test
    void 로또_번호가_1보다_작거나_45보다_큰_경우_예외가_발생한다() {
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45 사이어야 합니다.");

        List<Integer> aboveRangeNumbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(aboveRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45 사이어야 합니다.");
    }
}
