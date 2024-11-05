package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Lotto 객체 생성 시 6개의 숫자가 아닌 경우 예외 발생")
    void createLottoWithInvalidSize() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("Lotto 객체 생성 시 중복된 숫자가 있는 경우 예외 발생")
    void createLottoWithDuplicateNumbers() {
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicateNumbers));
        assertEquals("[ERROR] 로또 번호에 중복된 값이 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("Lotto 객체 생성 시 숫자가 1~45 범위를 벗어나는 경우 예외 발생")
    void createLottoWithOutOfRangeNumbers() {
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 46);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(outOfRangeNumbers));
        assertEquals("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("올바른 6개의 숫자로 Lotto 객체 생성")
    void createLottoWithValidNumbers() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }
}
