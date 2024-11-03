package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("구매 금액이 1000의 배수가 아닐 경우 예외가 발생한다.")
    void givenInvalidAmount_whenValidateMultipleOfThousand_thenThrowsException() {
        // given
        int invalidAmount = 2500;

        // when & then
        assertThatThrownBy(() -> PurchaseAmountValidator.validateMultipleOfThousand(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액이 1000의 배수일 경우 예외가 발생하지 않는다.")
    void givenValidAmount_whenValidateMultipleOfThousand_thenDoesNotThrowException() {
        // given
        int validAmount = 3000;

        // when & then
        assertDoesNotThrow(() -> PurchaseAmountValidator.validateMultipleOfThousand(validAmount));
    }

    @Test
    @DisplayName("구매 금액 입력이 숫자가 아닐 경우 예외가 발생한다.")
    void givenNonNumericInput_whenValidateNumeric_thenThrowsException() {
        // given
        String invalidInput = "string";

        // when & then
        assertThatThrownBy(() -> PurchaseAmountValidator.validateNumeric(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액 입력이 숫자일 경우 예외가 발생하지 않는다.")
    void givenNumericInput_whenValidateNumeric_thenDoesNotThrowException() {
        // given
        String validInput = "1000";

        // when & then
        assertDoesNotThrow(() -> PurchaseAmountValidator.validateNumeric(validInput));
    }
}
