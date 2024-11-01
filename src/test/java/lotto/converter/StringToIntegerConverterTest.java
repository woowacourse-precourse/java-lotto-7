package lotto.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToIntegerConverterTest {

    @ParameterizedTest
    @ValueSource(strings = { "a", "pobi", "홍길동"})
    void 문자열_Integer_변환_실패(String input) {
        //given
        TypeConverter<String, Integer> converter = new StringToIntegerConverter();

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("문자열_Integer_성공")
    void 문자열_Integer_변환_성공(String input, Integer expected) {
        //given
        TypeConverter<String, Integer> converter = new StringToIntegerConverter();

        //when
        Integer result = converter.convert(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> 문자열_Integer_성공() {
        return Stream.of(
            Arguments.of("1", 1),
            Arguments.of("10000", 10000),
            Arguments.of("123456789", 123456789)
        );
    }
}