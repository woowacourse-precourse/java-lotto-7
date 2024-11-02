package lotto.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "0", "-1000"})
    void 구입금액이_양의_정수가_아닐경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "1.2.3.4.5.6", "1,2,3,4,5,6,"})
    void 당첨번호를_구분자로_구분할수_없으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,A,6", "1,2,3,4,0,6", "1,2,3,4,-10,6"})
    void 당첨번호_구분자_사이값이_양의_정수가_아닐경우_예외를_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "0", "-1000"})
    void 보너스_번호가_양의_정수가_아닐경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}