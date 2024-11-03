package lotto.util.validator;

import lotto.util.parser.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void 입력값이_비어있을_때_예외발생(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12a34"})
    void 입력값이_숫자가_아닐때_예외발생(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000"})
    void 입력값이_유효할_때_예외발생하지않음(String input) {
        assertDoesNotThrow(() -> InputValidator.validateInputValue(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void 로또번호가_비어있을때_예외발생(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputLottoValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("로또번호_유효성_테스트_입력값")
    void 로또번호가_유효하지_않을때_예외발생(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputLottoValue(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Object[][] 로또번호_유효성_테스트_입력값() {
        return new Object[][] {
                {"46,1,2,3,4,5"},
                {"0,120,111,3,4,5"}
        };
    }

    @Test
    void 로또번호가_유효할_때_예외발생하지않음() {
        assertDoesNotThrow(() -> InputValidator.validateInputLottoValue("1,2,3,4,5,6"));
    }
}
