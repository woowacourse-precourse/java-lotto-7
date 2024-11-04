package lotto.model;

import static lotto.ExceptionMessage.WINNING_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBER_LENGTH_EXCEPTION;
import static lotto.ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨_번호를_저장한다() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningNumbers.getWinningNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_LENGTH_EXCEPTION.message());
    }

    @Test
    void 당첨_번호의_범위가_1부터_45_사이가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 46, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION.message());
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_DUPLICATE_EXCEPTION.message());
    }
}
