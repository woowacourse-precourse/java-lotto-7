package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 문자가 입력될 경우 예외가 발생한다.")
    void validateNumber() {
        // given
        String input = "a";
        // when, then
        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자를 1개만 입력할 경우 예외가 발생하지 않는다.")
    void readOneNumber() {
        // given
        String input = "1";
        // when
        assertThatNoException()
                .isThrownBy(() -> InputValidator.validateWinningNumberFormat(input));
    }

    @Test
    @DisplayName("형식에 맞추어 입력할 경우 예외가 발생하지 않는다.")
    void readWinningNumberFormat() {
        // given
        String input = "1,2,3,4,5,6";
        // when
        assertThatNoException()
                .isThrownBy(() -> InputValidator.validateWinningNumberFormat(input));
    }

    @Test
    @DisplayName("형식에 맞추지 않고 입력할 경우 예외가 발생한다.")
    void validateWinningNumberFormat() {
        // given
        String input = "1,2,3,4,5,6,";
        // when, then
        assertThatThrownBy(() -> InputValidator.validateWinningNumberFormat(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}