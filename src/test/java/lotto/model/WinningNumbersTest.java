package lotto.model;

import static lotto.utils.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.utils.Error.NOT_SIX_WINNING_NUMBERS;
import static lotto.utils.Error.WINNING_NUMBERS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_SIX_WINNING_NUMBERS.getDescription());
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_WINNING_NUMBERS.getDescription());
    }

    @Test
    void 당첨_번호가_1에서_45를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_OUT_OF_RANGE.getDescription());
    }
}