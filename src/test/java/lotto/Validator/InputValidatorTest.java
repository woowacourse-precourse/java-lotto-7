package lotto.Validator;

import static lotto.error.ErrorCode.NOT_NUMERIC_INPUT;
import static lotto.error.ErrorCode.NULL_OR_BLANK_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("문자열이 공백이거나 빈 문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void validateInput_NullOrBlank(String input) {

        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_OR_BLANK_INPUT.getMessage());
    }

    @DisplayName("문자열이 숫자가 아니라면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "*", "."})
    void validateInput_nonNumeric(String input) {

        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMERIC_INPUT.getMessage());
    }

    @DisplayName("문자열이 공백이거나 빈 문자열이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void validateNullOrBlank(String input) {

        assertThatThrownBy(() -> InputValidator.validateNullOrBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_OR_BLANK_INPUT.getMessage());
    }

    @DisplayName("문자열 리스트 중에 비어있거나 숫자가 아닌 값이 없다면 정상적으로 통과한다.")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    void validateNumbers_pass(List<String> numbers) {

        assertDoesNotThrow(() -> InputValidator.validateNumbers(numbers));
    }

    @DisplayName("문자열 리스트 중에 비어있거나 숫자가 아닌 값이 있다면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void validateNumbers(List<String> numbers) {

        assertThatThrownBy(() -> InputValidator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> provideValidNumbers() {
        return Stream.of(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("10", "20", "30"),
                Arrays.asList("123", "456", "789")
        );
    }

    private static Stream<List<String>> provideNumbers() {
        return Stream.of(
                Arrays.asList("1", " ", "3"),
                Arrays.asList("10", "20", "a"),
                Arrays.asList(null, "456", "789")
        );
    }



}