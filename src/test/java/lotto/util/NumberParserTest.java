package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberParserTest {

    private final NumberConverter numberConverter = new NumberConverter();
    private final NumberParserWithComma numberParser = new NumberParserWithComma(numberConverter);

    @Test
    @DisplayName("입력받은 숫자 문자열을 콤마 단위로 잘라 set으로 저장한다")
    void shouldParseNumberStringWithComma() {
        // given
        String input = "1,2,3";

        // when
        Set<Integer> parsedNumbers = numberParser.parseNumbers(input);

        // then
        assertThat(parsedNumbers).isEqualTo(Set.of(1,2,3));
    }

    @Test
    @DisplayName("입력받은 숫자 문자열 양쪽에 공백이 있으면 제거하고 반환한다")
    void shouldParseNumberStringWithCommaAndRemoveTrim() {
        // given
        String input = " 1,2,3 ";

        // when
        Set<Integer> parsedNumbers = numberParser.parseNumbers(input);

        // then
        assertThat(parsedNumbers).isEqualTo(Set.of(1,2,3));
    }

    @Test
    @DisplayName("입력받은 숫자 문자열 사이에 공백이 있다면 제거하고 반환한다")
    void shouldParseNumberStringWithCommaAndRemoveTrim2() {
        // given
        String input = "1, 2,  3";

        // when
        Set<Integer> parsedNumbers = numberParser.parseNumbers(input);

        // then
        assertThat(parsedNumbers).isEqualTo(Set.of(1,2,3));
    }
}
