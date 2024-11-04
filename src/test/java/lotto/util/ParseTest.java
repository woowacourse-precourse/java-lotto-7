package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ParseTest {

    @DisplayName("유효하지 않는 포맷의 문자열 예외")
    @ParameterizedTest
    @MethodSource("wrongNumbers")
    void formatTest(String input) {
        Parse parse = new Parse();
        assertThatThrownBy(() -> parse.StringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> wrongNumbers() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("three"),
                Arguments.of("10d"),
                Arguments.of("1 0"),
                Arguments.of("10.5")
        );
    }

    @DisplayName("정수로 변환 성공")
    @ParameterizedTest
    @MethodSource("numbers")
    void BlankTest(String input, Integer expected) {
        Parse parse = new Parse();
        assertThat(parse.StringToInteger(input)).isEqualTo(expected);
    }

    static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of("100", 100),
                Arguments.of("-10", -10),
                Arguments.of("45", 45),
                Arguments.of("45 ", 45),
                Arguments.of(" 45", 45),
                Arguments.of("0", 0)
        );
    }

}