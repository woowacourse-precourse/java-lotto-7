package lotto.global.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberFormatterTest {

    @Test
    @DisplayName("입력값에 콤마가 포함된 경우 제거하여 반환")
    void shouldRemoveCommas_whenInputContainsCommas() {
        String input = "1,000,000";
        String expected = "1000000";
        assertEquals(expected, NumberFormatter.removeCommas(input));
    }

    @Test
    @DisplayName("입력값에 콤마가 없는 경우 그대로 반환")
    void shouldReturnSameString_whenInputDoesNotContainCommas() {
        String input = "1000000";
        String expected = "1000000";
        assertEquals(expected, NumberFormatter.removeCommas(input));
    }

    @Test
    @DisplayName("입력값에 앞뒤 공백이 있는 경우 공백 제거 후 반환")
    void shouldTrimWhitespace_whenInputContainsLeadingAndTrailingSpaces() {
        String input = "  1,000,000  ";
        String expected = "1000000";
        assertEquals(expected, NumberFormatter.removeCommas(input));
    }

    @Test
    @DisplayName("문자열을 정수로 변환")
    void shouldParseToInt_whenInputIsNumericString() {
        String input = "10,000";
        int expected = 10000;
        assertEquals(expected, NumberFormatter.parseToInt(input));
    }

    @Test
    @DisplayName("입력값이 숫자가 아닐 경우 NumberFormatException 발생")
    void shouldThrowException_whenInputIsNotNumeric() {
        Exception exception = assertThrows(NumberFormatException.class, () ->
                NumberFormatter.parseToInt("10,00a"));
        assertEquals("[ERROR] 숫자가 아닌 다른 입력입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력값이 음수일 경우 정상적으로 정수로 변환")
    void shouldParseNegativeNumber_whenInputIsNegativeNumericString() {
        String input = "-10,000";
        int expected = -10000;
        assertEquals(expected, NumberFormatter.parseToInt(input));
    }

    @Test
    @DisplayName("입력값이 큰 수일 경우 정상적으로 정수로 변환")
    void shouldParseLargeNumber_whenInputIsLargeNumericString() {
        String input = "1,000,000,000";
        int expected = 1000000000;
        assertEquals(expected, NumberFormatter.parseToInt(input));
    }



    @Test
    @DisplayName("중간에 공백이 있는 경우 모든 공백이 제거되는지 확인")
    void shouldRemoveAllWhiteSpaces_whenContainsSpacesInMiddle() {
        String input = "Hello   World";
        String expected = "HelloWorld";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("앞뒤에 공백이 있는 경우 모든 공백이 제거되는지 확인")
    void shouldRemoveAllWhiteSpaces_whenContainsLeadingAndTrailingSpaces() {
        String input = "   HelloWorld   ";
        String expected = "HelloWorld";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("탭과 줄바꿈이 포함된 경우 모든 공백이 제거되는지 확인")
    void shouldRemoveAllWhiteSpaces_whenContainsTabsAndNewlines() {
        String input = "Hello\tWorld\nNew Line";
        String expected = "HelloWorldNewLine";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("연속된 공백이 포함된 경우 모든 공백이 제거되는지 확인")
    void shouldRemoveAllWhiteSpaces_whenContainsMultipleConsecutiveSpaces() {
        String input = "Hello      World";
        String expected = "HelloWorld";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("입력값이 비어 있는 경우 빈 문자열 반환")
    void shouldReturnEmptyString_whenInputIsEmpty() {
        String input = "";
        String expected = "";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("공백만 있는 입력값인 경우 빈 문자열 반환")
    void shouldReturnEmptyString_whenInputContainsOnlySpaces() {
        String input = "     ";
        String expected = "";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("탭과 줄바꿈만 포함된 입력값인 경우 빈 문자열 반환")
    void shouldReturnEmptyString_whenInputContainsOnlyTabsAndNewlines() {
        String input = "\t\n\t";
        String expected = "";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

    @Test
    @DisplayName("공백이 없는 경우 입력값이 그대로 반환")
    void shouldReturnSameString_whenInputHasNoWhiteSpaces() {
        String input = "HelloWorld";
        String expected = "HelloWorld";
        assertEquals(expected, NumberFormatter.removeAllWhiteSpaces(input));
    }

}