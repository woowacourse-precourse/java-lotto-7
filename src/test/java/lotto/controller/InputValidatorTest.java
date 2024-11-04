package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ExceptionCode.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("구입 금액 입력이 수가 아닐 경우 예외가 발생한다.")
    @Test
    void validateBudgetNotNumber() {
        assertThatThrownBy(() -> InputValidator.validateBudgetInput("l  s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER.message());
    }

    @DisplayName("당첨 번호 입력이 공백이면 예외가 발생한다.")
    @Test
    void validateWinningNumbersBlankException() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER.message());
    }

    @DisplayName("당첨 번호 입력이 너무 많은 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbersTooMany() {
        assertThatCode(() -> InputValidator.validateWinningNumbers("1, 2, 3, 4, 5,6, 7,  8 ,9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INCORRECT_NUMBER_COUNTS.message());
    }

    @DisplayName("당첨 번호 입력이 너무 적은 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbersTooSmall() {
        assertThatCode(() -> InputValidator.validateWinningNumbers("1, 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INCORRECT_NUMBER_COUNTS.message());
    }

    @DisplayName("당첨 번호 입력에 범위를 초과하는 수가 있는 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbersInRange() {
        assertThatCode(() -> InputValidator.validateWinningNumbers("1, 2, 3, 100, 4, 45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OUT_OF_RANGE.message());
    }

    @DisplayName("당첨 번호 입력에 중복된 수가 있는 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbersDuplicated() {
        assertThatCode(() -> InputValidator.validateWinningNumbers("1, 2,3,7,  7 ,9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER.message());
    }
}
