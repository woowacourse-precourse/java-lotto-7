package lotto.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToIntegerListConverterTest {

    @ParameterizedTest
    @ValueSource(strings = { "1,pobi,홍길동"})
    void 문자열_List_Integer_변환_실패(String input) {
        //given
        TypeConverter<String, List<Integer>> converter = new StringToIntegerListConverter();

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("문자열_List_Integer_성공")
    void 문자열_List_Integer_변환_성공(String input, List<Integer> expected) {
        //given
        TypeConverter<String, List<Integer>> converter = new StringToIntegerListConverter();

        //when
        List<Integer> result = converter.convert(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> 문자열_List_Integer_성공() {
        return Stream.of(
            Arguments.of("1,2,3", List.of(1, 2, 3)),
            Arguments.of("10000 , 20000 ,30000", List.of(10000, 20000, 30000)),
            Arguments.of("123456789,1234567890", List.of(123456789, 1234567890))
        );
    }
}