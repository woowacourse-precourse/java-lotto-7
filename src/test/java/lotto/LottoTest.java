package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("로또 번호가 1에서 45 사이에 있지 않으면 예외가 발생한다.")
    void 로또_번호가_1에서_45_사이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 정상적으로 생성되는지 확인한다.")
    void 로또_번호가_정상적으로_생성된다() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    @DisplayName("로또 번호가 정렬된 상태로 반환되는지 확인한다.")
    void 로또_번호가_정렬된_상태로_반환된다() {
        List<Integer> unorderedNumbers = List.of(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(unorderedNumbers);
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }
    @Test
    @DisplayName("보너스 번호가 1에서 45 사이가 아니면 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> InputPrice.validateBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> InputPrice.validateBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    @Test
    @DisplayName("로또 번호에 중복이 있는 경우 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_포함되면_예외가_발생한다() {
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 4, 5);
        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호에 중복된 숫자가 있습니다.");
    }

}
