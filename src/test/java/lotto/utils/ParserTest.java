package lotto.utils;

import lotto.exception.ParserException;
import lotto.exception.message.ParserExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    @DisplayName("숫자로 이루어진 문자열을 입력하면 숫자를 반환한다.")
    void returnNumber() {
        int expectedResult = 1000;
        int result = Parser.parseStringToInt("1000");

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("빈 문자열을 입력하면 예외를 발생한다.")
    void throwExceptionWhenEmptyString() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
            Parser.parseStringToInt("")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    @DisplayName("숫자가 아닌 값을 포함한 문자열을 입력하면 예외를 발생한다.")
    void throwExceptionWhenInfoIncludeNonNumber() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
            Parser.parseStringToInt("123a")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NOT_NUMBER.getMessage())
        );
    }

}