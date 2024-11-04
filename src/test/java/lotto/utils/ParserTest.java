package lotto.utils;

import static lotto.utils.Parser.parseStringToInteger;
import static lotto.utils.Parser.parseStringToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {
    @Test
    void 문자열_정수_변환_메소드_정상_기능_테스트() {
        // Given
        String numberInput = "10";
        // When
        Integer parsedNumber = parseStringToInteger(numberInput);
        // Then
        assertThat(parsedNumber).isEqualTo(10);
    }

    @Test
    void 문자열_정수_변환_메소드_예외_테스트() {
        String numberInput = "10!";
        assertThatThrownBy(()->{
            parseStringToInteger(numberInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static final Stream<Arguments> normalWinningNumberArguments() {
        return Stream.of(
            Arguments.arguments("1,2,3,4,5,6", List.of(1,2,3,4,5,6)),
            Arguments.arguments("3,10,23,4,5,45", List.of(3,10,23,4,5,45)),
            Arguments.arguments("5,10,15,20,25,30", List.of(5,10,15,20,25,30))
        );
    }
    @ParameterizedTest
    @MethodSource("normalWinningNumberArguments")
    void 문자열_정수_리스트_변환_메소드_정상_기능_테스트(String numbersInput, List<Integer> expected) {
        assertThat(parseStringToIntegerList(numbersInput)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,ij", "...,1,o"})
    void 문자열_정수_리스트_변환_메소드_예외_테스트(String numbersInput) {
        assertThatThrownBy(()-> parseStringToIntegerList(numbersInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
