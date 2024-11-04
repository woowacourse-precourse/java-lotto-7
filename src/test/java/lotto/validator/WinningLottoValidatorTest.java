package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;
import static lotto.message.ExceptionMessage.INVALID_DUPLICATION_INPUT;
import static lotto.message.ExceptionMessage.INVALID_RANGE_INPUT;
import static lotto.message.ExceptionMessage.INVALID_SIZE_INPUT;
import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;
import static lotto.validator.WinningLottoValidator.INPUT;
import static lotto.validator.WinningLottoValidator.MAX_VALUE;
import static lotto.validator.WinningLottoValidator.MIN_VALUE;
import static lotto.validator.WinningLottoValidator.SIZE;
import static lotto.validator.WinningLottoValidator.TYPE;
import static lotto.validator.WinningLottoValidator.validateWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 당첨_번호_목록에_빈_값이_들어오면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(INVALID_BLANK_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,1,4,13,21,33", "1.5,3,7,15,32,43", "1,3,5,14,22,45]"})
    void 당첨_번호_중_정수가_아닌_값이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_TYPE_INPUT.getMessage(), INPUT, TYPE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,4,18,24,37", "1,8,14,25,33,46"})
    void 당첨_번호_중_1_미만_45_초과인_값이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_RANGE_INPUT.getMessage(), INPUT, MIN_VALUE, MAX_VALUE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1", "1,2,3,4,5,6,7"})
    void 당첨_번호_목록의_사이즈가_6이_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_SIZE_INPUT.getMessage(), INPUT, SIZE, TYPE)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,3,3,14,22,45", "1,8,11,41,41,42"})
    void 당첨_번호_중_중복값이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ExceptionMessage.getPrefix())
                .hasMessage(
                        String.format(INVALID_DUPLICATION_INPUT.getMessage(), INPUT)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"8,21,23,   41  ,42,43", "8,21,23,41,42,43  ", "    8,21,23,41,42,43"})
    void 당첨_번호_앞뒤에_공백이_있어도_예외가_발생하지_않는다(String input) {
        assertThatCode(() -> validateWinningNumbers(input))
                .doesNotThrowAnyException();
    }

}