package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ExceptionCode.IS_NOT_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("입력이 수가 아닐 경우 예외가 발생한다.")
    @Test
    void validateBudgetInput() {
        assertThatThrownBy(() -> InputValidator.validateBudgetInput("l  s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER.message());
    }

    @DisplayName("입력이 수 배열이 아니면 예외가 발생한다.")
    @Test
    void validateWinningNumbers() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER.message());
    }
}