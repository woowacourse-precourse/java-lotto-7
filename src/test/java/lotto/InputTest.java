package lotto;

import lotto.exception.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 구입금액이_빈값인지_확인한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"55g5,3215g,6t123", "ttsads"})
    void 구입금액이_숫자인지_확인한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-5000", "-6000", "-14000"})
    void 구입금액이_양수인지_확인한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NEGATIVE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 00", "-50 00", "1500 0", "14 000"})
    void 구입금액_사이_공백이_있는지_확인한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,5,6,h,5,6", "5,25,31,37,40,4a", "1,2,ss,5,6,18", "4,10,15,30,test,35"})
    void 당첨번호가_숫자인지_확인한다(String input) {
        List<String> list = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-5,6,7,10,16", "-5,-25,-31,-37,-40,45", "1,2,4,5,6,-18", "4,10,15,30,-1,35"})
    void 당첨번호가_양수인지_확인한다(String input) {
        List<String> list = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NEGATIVE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 보너스번호가_비어있는지_확인한다(String input) {
        input = input.replaceAll(" ", "");
        String finalInput = input;
        assertThatThrownBy(() -> InputValidator.validateInput(finalInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ddd", " 1d", "2 d", "4.4"})
    void 보너스번호가_숫자인지_확인한다(String input) {
        input = input.replaceAll(" ", "");
        String finalInput = input;
        assertThatThrownBy(() -> InputValidator.validateInput(finalInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", " -5", "-2 ", "-4"})
    void 보너스번호가_양수인지_확인한다(String input) {
        input = input.replaceAll(" ", "");
        String finalInput = input;
        assertThatThrownBy(() -> InputValidator.validateInput(finalInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NEGATIVE_NUMBER.getMessage());
    }
}
