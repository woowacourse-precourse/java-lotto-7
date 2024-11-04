package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

public class WinningNumbersValidatorTest {
    @Test
    void 당첨_번호_숫자가_아니면_예외_발생() {
        String input = "a, 12, 22, 31, 35, b1";

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 당첨_번호_1이상_45이하_아니면_예외_발생() {
        String input = "1, 12, 22, 31, 35, 59";

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 당첨_번호_6개_아니면_예외_발생() {
        String input = "1, 22, 31, 35";

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COUNT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 당첨_번호_중복숫자_있으면_예외_발생() {
        String input = "1, 22, 22, 31, 35, 42";

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
