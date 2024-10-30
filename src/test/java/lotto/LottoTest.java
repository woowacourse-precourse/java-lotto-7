package lotto;

import lotto.global.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBERS_IN_LOTTO.getMessage());
    }
}
