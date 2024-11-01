package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ExceptionCode.IS_NOT_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("입력이 수가 아닐 경우 예외가 발생한다.")
    @Test
    void validateMoneyInput() {
        assertThatThrownBy(() -> InputValidator.validateMoneyInput("l  s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_NUMBER.message());
    }

    @Test
    void validateWinningNumbers() {
    }
}