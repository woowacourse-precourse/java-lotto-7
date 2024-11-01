package lotto.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToLongConverterTest {

    @ParameterizedTest
    @ValueSource(strings = { "b", "woni", "고길동"})
    void 문자열_Long_변환_실패(String input) {
        //given
        TypeConverter<String, Long> converter = new StringToLongConverter();

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("문자열_Long_성공")
    void 문자열_Long_변환_성공(String input, Long expected) {
        //given
        TypeConverter<String, Long> converter = new StringToLongConverter();

        //when
        Long result = converter.convert(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> 문자열_Long_성공() {
        return Stream.of(
            Arguments.of("1", 1L),
            Arguments.of("10000", 10000L),
            Arguments.of("123456789", 123456789L)
        );
    }
}