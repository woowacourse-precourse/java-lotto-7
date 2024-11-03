package lotto.input;

import static lotto.exception.ExceptionMessage.*;
import static lotto.input.BonusNumberProcessor.validateAndParse;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class BonusNumberProcessorTest {
    private final List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlank(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(winNumbers, input))
                .withMessage(EMPTY_INPUT.getMessage());
    }

    @DisplayName("문자열인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"하나", "둘", "셋"})
    void testString(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(winNumbers, input))
                .withMessage(NON_NUMERIC_INPUT.getMessage());
    }

    @DisplayName("음수, 0, 실수인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1.1", "   -  2", "    0   ", "   5.  4"})
    void testInvalidIntInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(winNumbers, input))
                .withMessage(ONLY_POSITIVE_INPUT.getMessage());
    }

    @DisplayName("숫자 범위가 1 ~ 45를 벗어난 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"46", "47", "100"})
    void testOutOfRage(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(winNumbers, input))
                .withMessage(OUT_OF_RANGE_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호의 숫자와 겹치는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "6"})
    void testDuplicate(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(winNumbers, input))
                .withMessage(DUPLICATE_WITH_WINNING_NUMBER.getMessage());
    }

    @DisplayName("유효한 입력 - 보너스 번호 반환")
    @ParameterizedTest
    @CsvSource(value = {"7,7", "10,10", "45,45"})
    void testValid(String input, int expected) {
        // given, then
        int result = validateAndParse(winNumbers, input);

        // then
        assertEquals(expected, result);
    }

}
