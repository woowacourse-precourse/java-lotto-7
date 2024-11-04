package lotto.validator;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("유효한 금액일 때 예외가 발생하지 않는다.")
    void validateAmount_withValidAmount() {
        int validAmount = 1000;

        assertThatCode(() -> PurchaseAmountValidator.validateAmount(validAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("최소 금액보다 적은 금액일 때 예외가 발생한다.")
    void validateAmount_withAmountBelowMinimum() {
        int belowMinimumAmount = 500;

        assertThatThrownBy(() -> PurchaseAmountValidator.validateAmount(belowMinimumAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_MIN_PRICE.getMessage());
    }

    @Test
    @DisplayName("최대 금액보다 많음 금액일 때 예외가 발생한다.")
    void validateAmount_withAmountExceedMaximum(){
        int exceedMaximumAmount = 1000000;

        assertThatThrownBy(() -> PurchaseAmountValidator.validateAmount(exceedMaximumAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_MAX_PRICE.getMessage());
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액일 때 예외가 발생한다.")
    void validateAmount_withNonDivisibleAmount() {
        int nonDivisibleAmount = 1500;

        assertThatThrownBy(() -> PurchaseAmountValidator.validateAmount(nonDivisibleAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_INVALID_DIVISIBILITY.getMessage());
    }
}

