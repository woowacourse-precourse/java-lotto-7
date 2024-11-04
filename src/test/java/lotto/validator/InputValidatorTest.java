package lotto.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static lotto.constants.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 구입금액에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void 구입금액이_양의_정수가_아닐경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_POSITIVE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 당첨번호에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1*2*3*4*5*6"})
    void 당첨번호를_구분자로_구분할수_없으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_WIN_NUMBERS.getMessage());
    }

    @Test
    void 당첨번호_마지막에_구분자가_올경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_TRAILING_COMMA.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,A,6", "1,2,3,4,0,6", "1,2,3,4,-10,6"})
    void 당첨번호_구분자_사이값이_양의_정수가_아닐경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_POSITIVE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 보너스_번호에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_EMPTY_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void 보너스_번호가_양의_정수가_아닐경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_POSITIVE_NUMBER.getMessage());
    }
}