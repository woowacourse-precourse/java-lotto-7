package lotto;

import lotto.controller.ErrorMessages;
import lotto.controller.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("구매금액이 0보다 큰 정수 형태가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1.2", "0", "-1", "abc", "##", " ", ""})
    void throwExceptionWhenPurchaseAmountIsNotPositiveInteger(String input) {
        // when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validatePaidAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_PAID_AMOUNT_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 쉼표와 0보다 큰 정수로 이루어진 형태가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2,", "abc", "$", "   ", "$,$", "-1.2,3,45"})
    void throwExceptionWhenFormOfWinningNumbersAreInvalid(String input) {
        // when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_WINNING_NUMBERS_FORMAT);
    }

}
