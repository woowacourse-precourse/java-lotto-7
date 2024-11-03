package lotto.util.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerNumbersValidatorTest {

    @Test
    @DisplayName("정상적인 입력이 들어오는 경우")
    void NormalWinnerNumber(){
        //given
        String winnerNumberInput = "1,2,3,4,5,6";

        //when
        WinnerNumbersValidator.validateWinnerNumber(winnerNumberInput);
    }

    @Test
    @DisplayName("값이 비어있는 경우")
    void InputIsEmpty(){
        //given
        String winnerNumberInput = "";

        //then
        assertThrows(IllegalArgumentException.class,

                //when
                () -> WinnerNumbersValidator.validateEmptyValue(winnerNumberInput));
    }

    @Test
    @DisplayName("문자열의 맨 앞에 공백이 있는지 검사")
    void InputHasWhitespaceAtHead(){
        //given
        String winnerNumberInput = " 1,2,3,4,5,6";

        //then
        assertThrows(IllegalArgumentException.class,

                //when
                () -> WinnerNumbersValidator.validateWhitespaceAtHeadOrTail(winnerNumberInput));
    }

    @Test
    @DisplayName("문자열의 맨 뒤에 공백이 있는지 검사")
    void InputHasWhitespaceAtTail(){
        //given
        String winnerNumberInput = "1,2,3,4,5,6 ";

        //then
        assertThrows(IllegalArgumentException.class,

                //when
                () -> WinnerNumbersValidator.validateWhitespaceAtHeadOrTail(winnerNumberInput));
    }

    @Test
    @DisplayName("문자열에 ,를 제외하고 숫자만 존재하는지 검증")
    void InputIncludeDigitExceptComma(){
        //given
        String winnerNumberInput = "1,2,-3,4,5,6";

        //then
        assertThrows(IllegalArgumentException.class,

                //when
                () -> WinnerNumbersValidator.validateEachCharacterIsDigit(winnerNumberInput, null));
    }

    @Test
    @DisplayName("문자열을 ,로 분리하였을 경우 비어있는 값이 있는지 검증")
    void InputHasEmptyValueWhenSplitByComma(){
        //given
        String winnerNumberInput = "1,2,3,,5,6";

        //then
        assertThrows(IllegalArgumentException.class,

                //when
                () -> WinnerNumbersValidator.validateWinnerNumber(winnerNumberInput));
    }

    @Test
    @DisplayName("문자열을 ,로 분리하였을 경우 0으로 시작하는 정수가 있는지 검증")
    void InputStartWithZeroWhenSplitByComma(){
        //given
        String winnerNumberInput = "1,2,3,4,05,6";

        //then
        assertThrows(IllegalArgumentException.class,

                //when
                () -> WinnerNumbersValidator.validateWinnerNumber(winnerNumberInput));
    }

}