package lotto.validator;

import static lotto.exception.ExceptionMessage.BLANK_WINNING_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.DUPLICATE_WINNING_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_LOTTO_NUMBERS_PATTERN;
import static lotto.exception.ExceptionMessage.OUT_OF_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @Test
    void 유효한_로또번호_검증시_예외가_발생하지_않는다() {
        // Given
        String winningNumbers = "3, 4, 5, 11, 12, 45";

        // When & Then
        assertDoesNotThrow(() -> WinningNumbersValidator.validate(winningNumbers));
    }

    @Test
    void 유효한_로또번호는_공백이_포함되어도_예외가_발생하지_않는다() {
        // Given
        String winningNumbers = " 1 , 12 , 23 , 34 , 45 , 6 ";

        // When & Then
        assertDoesNotThrow(() -> WinningNumbersValidator.validate(winningNumbers));
    }

    @Test
    void 빈_문자열_입력시_예외가_발생한다() {
        // Given
        String winningNumbers = "";

        // When & Then
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_WINNING_LOTTO_NUMBERS.getMessage());
    }

    @Test
    void 유효하지_않은_패턴의_로또_번호_입력시_예외가_발생한다() {
        // Given
        String winningNumbers = "-1, 0, 23, 34, abc, 45";

        // When & Then
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_LOTTO_NUMBERS_PATTERN.getMessage());
    }

    @Test
    void 로또_번호_범위를_벗어난_숫자_입력시_예외가_발생한다() {
        // Given
        String winningNumbers = "1, 2, 3, 4, 5, 100";

        // When & Then
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    void 당첨번호가_중복되면_예외가_발생한다() {
        // Given
        String winningNumbers = "1, 2, 3, 4, 5, 5";

        // When & Then
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_WINNING_NUMBERS.getMessage());
    }
}