package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidLottoNumbersThenCreatesInstance() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(validNumbers);

        assertThat(lotto.getNumbersAsUnmodifiableList())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void testLottoNumbersAreSorted() {
        List<Integer> unsortedNumbers = List.of(5, 3, 1, 6, 4, 2);
        Lotto lotto = Lotto.from(unsortedNumbers);

        assertThat(lotto.getNumbersAsUnmodifiableList())
                .containsExactly(1, 2, 3, 4, 5, 6);  // 오름차순 정렬 여부 확인
    }

    @Test
    void testInvalidLottoSizeThenThrowsException() {
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5);  // 5개일 때

        assertThatThrownBy(() -> Lotto.from(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }
}
