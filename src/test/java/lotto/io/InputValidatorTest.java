package lotto.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    @DisplayName("입력 값이 빈 값이라면 예외가 발생한다.")
    void should_throwException_When_InputIsEmpty() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "12a", "1a2"})
    @DisplayName("입력 값이 숫자가 아니라면 예외가 발생한다.")
    void should_throwException_When_InputIsNotNumber(String input) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
