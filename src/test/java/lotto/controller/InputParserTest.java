package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.exception.InputParserExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {

    // parseIntegers() 메서드에 대한 테스트 코드 작성

    @Test
    void 정상__parseIntegers() {
        // given
        String input = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> actual = InputParser.parseIntegers(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void 실패__parseIntegers_숫자가_아닌_문자() {
        // given
        String input = "1,2,3,4,5,a";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputParser.parseIntegers(input));

        // then
        assertEquals(InputParserExceptionMessage.NUMBER_ONLY.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__parseIntegers_요소가_없는경유() {
        // given
        String input = ",,";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputParser.parseIntegers(input));

        // then
        assertEquals(InputParserExceptionMessage.AT_LEAST_ONE_NUMBER.getMessage(), exception.getMessage());
    }

    // parseInteger() 메서드에 대한 테스트 코드 작성

    @Test
    void 성공__parseInteger() {
        // given
        String input = "1";
        int expected = 1;

        // when
        int actual = InputParser.parseInteger(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void 실패__parseInteger() {
        // given
        String input = "a";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputParser.parseInteger(input));

        // then
        assertEquals(InputParserExceptionMessage.NUMBER_ONLY.getMessage(), exception.getMessage());
    }
}