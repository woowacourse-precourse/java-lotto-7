package lotto.input;

import static lotto.exception.ExceptionMessage.*;
import static lotto.input.WinningNumberProcessor.validateAndParse;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberProcessorTest {
    @DisplayName("빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(input))
                .withMessage(EMPTY_INPUT.getMessage());
    }

    @DisplayName("입력 값의 맨 앞이나 맨 뒤에 쉼표가 오는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {", 1, 2, 3, 4, 5", ", 1, 2, 3, 4, 5, 6,", ", 1, 2, 3, 4, 5, 6,"})
    void testInputWithComma(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(input))
                .withMessage(INVALID_COMMA_POSITION.getMessage());
    }

    @DisplayName("문자가 포함된 경우 - IllegalArgumentException 반환")
    @Test
    void testStringInput(){
        // given
        String input = "1,2,3, 사, 5, 6";

        // when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParse(input))
                .withMessage(INVALID_COMMA_POSITION.getMessage());
    }




}
