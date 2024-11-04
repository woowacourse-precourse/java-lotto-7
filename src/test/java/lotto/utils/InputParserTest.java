package lotto.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    public void 쉼표로_구분된_문자열_목록_유효한입력_문자열_목록_반환() {
        //given
        String input = "1, 2, 3, 4, 5";
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5");

        //when
        List<String> result = InputParser.parseCommaSeparatedStrings(input);

        //then
        assertEquals(expected, result);
    }

    @Test
    void 문자열_목록을_정수_목록으로_변환_유효한입력_정수목록반환() {
        //given
        List<String> input = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        //when
        List<Integer> result = InputParser.convertStringsToIntegers(input);

        //then
        assertEquals(expected, result);
    }

    @Test
    void 문자열_목록을_정수_목록으로_변환_유효하지않은입력_예외발생() {
        //given
        List<String> input = Arrays.asList("1", "2", "a", "4", "5");

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputParser.convertStringsToIntegers(input);
        });

        //then
        assertEquals("입력에 숫자가 아닌 값이 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    void 문자열을_정수로_변환_유효한입력_정수반환() {
        //given
        String input = "123";
        int expected = 123;

        //when
        int result = InputParser.stringToInteger(input);

        //then
        assertEquals(expected, result);
    }

    @Test
    void 문자열을_정수로_변환_유효하지않은입력_예외발생() {
        //given
        String input = "abc";

        //when then
        assertThrows(NumberFormatException.class, () -> {
            InputParser.stringToInteger(input);
        });
    }
}