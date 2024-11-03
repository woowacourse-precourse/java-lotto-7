package lotto.validation;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

class WinningAndBonusNumbersValidatorTest {

    @Test
    void 올바른_로또_번호가_입력되면_예외가_발생하지_않는다() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatCode(() -> WinningAndBonusNumbersValidator.validateWinningAndBonusNumbers(validNumbers))
            .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호의_개수가_7개가_아니면_예외가_발생한다() {
        List<Integer> invalidQuantity = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> WinningAndBonusNumbersValidator.validateWinningAndBonusNumbers(invalidQuantity))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS_QUANTITY.getMessage());
    }

    @Test
    void 로또_번호에_범위를_벗어나는_숫자가_포함되면_예외가_발생한다() {
        List<Integer> outOfRangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 50);

        assertThatThrownBy(() -> WinningAndBonusNumbersValidator.validateWinningAndBonusNumbers(outOfRangeNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_포함되면_예외가_발생한다() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);

        assertThatThrownBy(() -> WinningAndBonusNumbersValidator.validateWinningAndBonusNumbers(duplicateNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
    }
}
