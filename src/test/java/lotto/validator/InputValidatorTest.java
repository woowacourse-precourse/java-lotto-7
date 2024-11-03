package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Nested
    class 숫자_입력_검증 {

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" "})
        void 숫자_입력은_비거나_공백으로_이루어진_문자열일_수_없다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "123abc", "!@#", "12.34"})
        void 숫자_입력은_정수_형식만_허용한다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    @Nested
    class 당첨_번호_입력_검증 {

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" "})
        void 당첨_번호_입력은_비거나_공백으로_이루어진_문자열일_수_없다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,,2,3,4,5,6", "1,2,3,,4,5,6"})
        void 당첨_번호에_중복된_콤마가_있으면_예외가_발생한다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2 ,a,4,5,6", "1,2;3,4,5,6", "1 2,3,4,5,6"})
        void 당첨_번호에_숫자와_숫자_사이에_콤마가_아닌_다른_문자가_있으면_예외가_발생한다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,41,42", "-10,20,30,40,41,42"})
        void 당첨_번호가_올바르게_콤마로_구분된_형식일_경우_예외가_발생하지_않는다(String input) {
            assertDoesNotThrow(() -> InputValidator.validateWinningNumbers(input));
        }
    }

}