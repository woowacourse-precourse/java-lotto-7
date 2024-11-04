package lotto.utils;

import java.util.List;
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
    @DisplayName("빈 문자열을 입력하면 예외를 발생시킨다.")
    void throwExceptionWhenInputIsEmpty() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.parseStringToInt("")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    @DisplayName("int형을 벗어나는 양의 정수가 입력되면 예외를 발생시킨다.")
    void throwExceptionWhenPositiveNumberExceedsIntRange() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.parseStringToInt("2147483648")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage())
        );
    }

    @Test
    @DisplayName("int형을 벗어나는 음의 정수가 입력되면 예외를 발생시킨다.")
    void throwExceptionWhenNegativeNumberExceedsIntRange() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.parseStringToInt("-2147483649")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage())
        );
    }

    @Test
    @DisplayName("소수가 입력되면 예외를 발생시킨다.")
    void throwExceptionWhenInputIsDecimalNumber() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.parseStringToInt("2.1")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NOT_NUMBER.getMessage())
        );
    }

    @Test
    @DisplayName("숫자가 아닌 값을 포함한 문자열을 입력하면 예외를 발생시킨다.")
    void throwExceptionWhenInvalidInputIncludeNonNumber() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.parseStringToInt("123a")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NOT_NUMBER.getMessage())
        );
    }
    @Test
    @DisplayName("구분자로 구분된 문자열을 입력하면 숫자 리스트를 반환한다.")
    void returnListOfNumbersWhenValidInput() {
        String input = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> result = Parser.splitBySeparator(input);

        Assertions.assertEquals(expectedNumbers.size(), result.size());
        for (int index = 0; index < expectedNumbers.size(); index++) {
            Assertions.assertEquals(expectedNumbers.get(index), result.get(index));
        }
    }

    @Test
    @DisplayName("구분자로 구분된 문자열이 비었다면 예외를 발생시킨다.")
    void throwExceptionWhenInvalidInputIsEmptyValue() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.splitBySeparator("")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    @DisplayName("구분자로 구분된 문자열에 빈 값을 포함하면 예외를 발생시킨다.")
    void throwExceptionWhenInvalidInputIncludesEmptyValue() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.splitBySeparator("1,2,,4,5,6")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    @DisplayName("구분자로 구분된 문자열에 숫자가 아닌 값을 포함하면 예외를 발생시킨다.")
    void throwExceptionWhenInvalidInputIncludeNonNumericValue() {
        String exceptionMessage = Assertions.assertThrows(ParserException.class, () ->
                Parser.splitBySeparator("1,2,a,4,5,6")
        ).getMessage();

        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NOT_NUMBER.getMessage())
        );
    }
}
