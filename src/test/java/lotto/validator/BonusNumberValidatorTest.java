package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;
import static lotto.message.ExceptionMessage.INVALID_DUPLICATION_INPUT;
import static lotto.message.ExceptionMessage.INVALID_RANGE_INPUT;
import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;
import static lotto.validator.BonusNumberValidator.INPUT;
import static lotto.validator.BonusNumberValidator.MAX_VALUE;
import static lotto.validator.BonusNumberValidator.MIN_VALUE;
import static lotto.validator.BonusNumberValidator.TYPE;
import static lotto.validator.BonusNumberValidator.validateBonusNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @NullAndEmptySource
    void 보너스_번호에_빈_값이_들어오면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(INVALID_BLANK_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1.5"})
    void 보너스_번호가_정수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_TYPE_INPUT.getMessage(), INPUT, TYPE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 보너스_번호가_1_미만이거나_45_초과이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_RANGE_INPUT.getMessage(), INPUT, MIN_VALUE, MAX_VALUE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 보너스_번호가_당첨_번호와_중복이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_DUPLICATION_INPUT.getMessage(), INPUT)
                );
    }
}