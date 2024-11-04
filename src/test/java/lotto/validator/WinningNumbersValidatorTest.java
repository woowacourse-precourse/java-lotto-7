package lotto.validator;

import lotto.common.ErrorMessage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 공백을_입력하면_예외_발생(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.BLANK_OR_NULL_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12, 13", "12.", "13a,14,15,16"})
    void 쉼표와_숫자_이외의_다른_문자를_입력하면_예외_발생(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_WINNING_INPUT_TYPE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,", ",1,2,3,4,5,6"})
    void 입력의_시작과_끝이_쉼표면_예외발생(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_START_END_POINT);
    }

    @Test
    void 올바른_문자열_입력시_리스트를_반환한다() {
        String input = "1,2,3,4,5,6";
        assertThat(WinningNumbersValidator.validateWinningNumbers(input)).isEqualTo(
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}