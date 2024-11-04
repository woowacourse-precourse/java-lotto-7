package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @Test
    void createLotto_ValidNumbers_Success() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void createLotto_InvalidNumberCount_ThrowsException() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5); // 5개
        assertThatThrownBy(() -> new Lotto(invalidNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void createLotto_DuplicateNumbers_ThrowsException() {
        List<Integer> duplicateNumbers = List.of(1, 2, 2, 3, 4, 5); // 중복 2
        assertThatThrownBy(() -> new Lotto(duplicateNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되면 안됩니다.");
    }

    @Test
    void createLotto_OutOfRangeNumbers_ThrowsException() {
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 46); // 0과 46
        assertThatThrownBy(() -> new Lotto(outOfRangeNumbers)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
    }
}
