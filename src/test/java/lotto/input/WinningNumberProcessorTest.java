package lotto.input;

import static lotto.exception.ExceptionMessage.*;
import static lotto.input.WinningNumberProcessor.processWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class WinningNumberProcessorTest {
    @DisplayName("빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> processWinningNumbers(input))
                .withMessage(EMPTY_INPUT.getMessage());
    }

    @DisplayName("입력 값의 맨 앞이나 맨 뒤에 쉼표가 오는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {", 1, 2, 3, 4, 5", ", 1, 2, 3, 4, 5, 6,", ", 1, 2, 3, 4, 5, 6,"})
    void testInputWithComma(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> processWinningNumbers(input))
                .withMessage(INVALID_COMMA_POSITION.getMessage());
    }

    @DisplayName("문자가 포함된 경우 - IllegalArgumentException 반환")
    @Test
    void testStringInput() {
        // given
        String input = "1,2,3, 사, 5, 6";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> processWinningNumbers(input))
                .withMessage(NON_NUMERIC_INPUT.getMessage());
    }

    @DisplayName("음수, 0, 실수인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1, -2, 3, 4, 5", "0, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5.0, 6", "1, 2, 3, 4, 5.2, 6"})
    void testInvalidIntInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> processWinningNumbers(input))
                .withMessage(ONLY_POSITIVE_INPUT.getMessage());
    }

    @DisplayName("유효한 입력 - List<Integer> 반환")
    @ParameterizedTest
    @MethodSource("provideValidInput")
    void testValidInput(String input, List<Integer> expected) {
        // given & when
        List<Integer> result = processWinningNumbers(input);

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideValidInput() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("1 , 2 , 3", List.of(1, 2, 3)),
                Arguments.of(" 1 , 2,  3  ,  4, 5, 6, 7", List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }
}
