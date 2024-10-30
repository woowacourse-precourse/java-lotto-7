package lotto.global.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParserTest {

    @Test
    @DisplayName("정상적인 숫자라면 int로 parse한다")
    void normalParse() throws Exception {
        // given
        String value = "3";

        // when
        Integer result = Parser.parseToInt(value);

        // then
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아니라면 에러를 반환한다")
    @MethodSource("providedParseError")
    void parseError(String value) throws Exception {
        // then
        assertThatThrownBy(() -> Parser.parseToInt(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
    }

    private static Stream<Arguments> providedParseError() {
        return Stream.of(
                Arguments.arguments("@"),
                Arguments.arguments("1a"),
                Arguments.arguments(" ")
        );
    }

}