package lotto.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void 금액_입력_검사_테스트() {
        //given
        String input1 = "2000";
        String input2 = "8000";

        //then
        Assertions.assertDoesNotThrow(() -> InputValidator.validateMoney(input1));
        Assertions.assertDoesNotThrow(() -> InputValidator.validateMoney(input2));
    }

    @Test
    void 금액_입력_검사_예외_테스트() {
        //given
        String notNum = "이천";
        String wrongInput = "3212";
        String empty = "";

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateMoney(notNum));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateMoney(wrongInput));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateMoney(empty));
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
}