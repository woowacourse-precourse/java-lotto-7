package lotto.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "323000"})
    void 금액_입력_검사_테스트(String input) {
        //when & then
        assertDoesNotThrow(() -> InputValidator.validateMoney(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"이천", "3212", "0", "", "12", "201"})
    void 금액_입력_검사_예외_테스트(String input) {
        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateMoney(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,46,3,4,5", "-1,2,3,4,5,6", "1;2;3;4;5;6", "1,2,3,4,5,6,7"})
    void 당첨_번호_입력_검사_예외_테스트(String input) {
        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateWinningNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "11,21,3,4,5,6"})
    void 당첨_번호_입력_검사_테스트(String input) {
        //when & then
        assertDoesNotThrow(() -> InputValidator.validateWinningNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "삼", "46"})
    void 보너스_번호_입력_검사_예외_테스트(String input) {
        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateBonusNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "45", "11", "22", "33"})
    void 보너스_번호_입력_검사_테스트(String input) {
        //when & then
        assertDoesNotThrow(() -> InputValidator.validateBonusNumber(input));
    }
}