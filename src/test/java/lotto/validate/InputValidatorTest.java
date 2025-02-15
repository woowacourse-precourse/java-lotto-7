package lotto.validate;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void 입력받은_금액이_화이트스페이스일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateAmountOfMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_WHITESPACE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "qwer", "apple"})
    void 입력받은_금액이_숫자가_아닌_문자일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateAmountOfMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_DIGIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"200000", "5000", "10000"})
    void 입력받은_금액이_숫자일_경우_예외가_발생하지_않는다(String input) {
        assertThatCode(() -> inputValidator.validateAmountOfMoney(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력받은_금액이_정수_최대값보다_클_경우_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateAmountOfMoney("2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.AMOUNT_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 입력받은_금액이_정수_최대값보다_작거나_같을_경우_예외가_발생하지_않는다() {
        assertThatCode(() -> inputValidator.validateAmountOfMoney("2147483647"))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력받은_당첨_번호에_화이트스페이스가_존재하는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.EMPTY_ELEM_EXIST.getMessage());
    }

    @Test
    void 입력받은_당첨_번호에_화이트스페이스가_존재하지_않는_경우_예외가_발생하지_않는다() {
        assertThatCode(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력받은_당첨_번호가_콤마로_끝나는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.ENDS_WITH_COMMA.getMessage());
    }

    @Test
    void 입력받은_당첨_번호가_콤마로_끝나지_않는_경우_예외가_발생하지_않는다() {
        assertThatCode(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력받은_당첨_번호에_숫자가_아닌_문자가_존재하는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_DIGIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void 입력받은_보너스_번호가_화이트스페이스일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_WHITESPACE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "asdf", "qwer"})
    void 입력받은_보너스_번호가_숫자가_아닌_문자인_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_DIGIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "45", "3"})
    void 입력받은_보너스_번호가_숫자인_경우_예외가_발생하지_않는다(String input) {
        assertThatCode(() -> inputValidator.validateBonusNumber(input))
                .doesNotThrowAnyException();
    }
}
