package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    StringParser stringParser;

    @BeforeEach
    void setUp() {
        stringParser = new StringParser();
    }

    @ParameterizedTest
    @MethodSource("parseStringToInteger")
    void 문자열을_정수로_변환한다(String string, int expected) {
        int parsedInt = stringParser.parseStringToInteger(string);
        assertThat(parsedInt).isEqualTo(expected);
    }

    public static Stream<Arguments> parseStringToInteger() {
        return Stream.of(
                Arguments.of("10", 10),
                Arguments.of("999", 999),
                Arguments.of("12341234", 12341234)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "helloWorld"})
    void 정수가_아닌_문자열을_입력받으면_예외가_발생한다(String string) {
        assertThatThrownBy(() -> stringParser.parseStringToInteger(string))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @MethodSource("parseStringToNumbers")
    void 문자열을_구분_문자로_분할하여_정수의_리스트로_반환한다(String string, String delimiter, List<Integer> expected) {
        List<Integer> numbers = stringParser.parseStringToNumbers(string, delimiter);
        assertThat(numbers).isEqualTo(expected);
    }

    public static Stream<Arguments> parseStringToNumbers() {
        return Stream.of(
                Arguments.of("1,2,3", ",", List.of(1, 2, 3)),
                Arguments.of("1:2:3", ":", List.of(1, 2, 3)),
                Arguments.of("123:234:345", ":", List.of(123, 234, 345))
        );
    }

}