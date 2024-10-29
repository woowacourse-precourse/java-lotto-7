package lotto.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}