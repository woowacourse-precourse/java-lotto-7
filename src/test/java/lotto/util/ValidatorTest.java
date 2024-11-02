package lotto.util;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 입력 테스트")
    public void isEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.isEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12test", "test", "123123abc"})
    @DisplayName("입력이 숫자가 아닌 문자로 구성되어 있는 확인")
    public void isDigitStringExceptionTest(String input) {
        assertThatThrownBy(() -> Validator.isDigitString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "20000"})
    @DisplayName("입력이 숫자로 구성되어 있을 때 정상동작 테스트")
    public void isDigitStringTest(String input) {
        assertThatNoException().isThrownBy(() -> Validator.isDigitString(input));
    }

    @ParameterizedTest
    @MethodSource("validNumberProvider")
    @DisplayName("숫자가 범위 내에 있을 때 정상동작 테스트")
    public void isNumberWithinRangeTest(int number, int minNumber, int maxNumber) {
        assertThatNoException().isThrownBy(() -> Validator.isNumberWithinRange(number, minNumber, maxNumber));
    }

    private static Object[][] validNumberProvider() {
        return new Object[][]{
                {5, 1, 10},
                {1, 1, 10},
                {10, 1, 10}
        };
    }

    @ParameterizedTest
    @MethodSource("invalidNumberProvider")
    @DisplayName("숫자가 범위 내에 포함되지 않는 예외 테스트")
    public void isNumberWithinRangeExceptionTest(int number, int minNumber, int maxNumber) {
        assertThatThrownBy(() -> Validator.isNumberWithinRange(number, minNumber, maxNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    private static Object[][] invalidNumberProvider() {
        return new Object[][]{
                {5, 0, 4},
                {1, 2, 4},
                {10, 2, 8}
        };
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483647", "1", "11111"})
    @DisplayName("INT 범위 테스트")
    public void isIntegerTest(String input) {
        assertThatNoException().isThrownBy(() -> Validator.isInteger(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "1111111111111"})
    @DisplayName("INT 범위 예외 테스트")
    public void isIntegerExceptionTest(String input) {
        assertThatThrownBy(() -> Validator.isInteger(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("validDivisibleNumber")
    @DisplayName("입력이 특정 숫자로 나누어 떨어지는지 테스트")
    public void isDivisibleByTest(int number, int divisor) {
        assertThatNoException().isThrownBy(() -> Validator.isDivisibleBy(number, divisor));
    }

    private static Object[][] validDivisibleNumber() {
        return new Object[][]{
                {1000, 1000},
                {10000, 2000},
                {20000, 5000}
        };
    }
}
