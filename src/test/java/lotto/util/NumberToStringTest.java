package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberToStringTest {
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("integerSample")
    @DisplayName("정수를 문자열로 변환")
    void integerToStringTest(int intNumber, String numberString) {

        assertEquals(NumberToString.integerToString(intNumber), numberString);
    }

    static Stream<Arguments> integerSample() {
        return Stream.of(
                Arguments.of(2_000_000_000, "2,000,000,000"),
                Arguments.of(1_500_000, "1,500,000"),
                Arguments.of(0, "0")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("decimalSample")
    @DisplayName("소수를 문자열로 변환")
    void decimalToStringTest(double doubleNumber, String numberString) {

        assertEquals(NumberToString.decimalToString(doubleNumber), numberString);
    }

    static Stream<Arguments> decimalSample() {
        return Stream.of(
                Arguments.of(100, "100.0"),
                Arguments.of(51.5, "51.5"),
                Arguments.of(1_000_000, "1,000,000.0")
        );
    }
}
