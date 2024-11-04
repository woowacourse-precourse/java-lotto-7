package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyValidatorTest {

    @Test
    void 유효_정수_문자열_정상() {
        String validToken = "10000";
        PurchaseMoneyValidator.validateInteger(validToken);
    }

    @Test
    void 유효하지_않은_정수_문자열_예외_발생() {
        String invalidToken = "jeon";
        assertThatThrownBy(() -> PurchaseMoneyValidator.validateInteger(invalidToken))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 천의_배수_아닌_경우_예외_발생() {
        int invalidAmount = 10001;
        assertThatThrownBy(() -> PurchaseMoneyValidator.validateDivisibleByThousand(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 천의_배수인_경우_정상() {
        int validAmount = 10000;
        PurchaseMoneyValidator.validateDivisibleByThousand(validAmount);
    }

    @Test
    void 음수_금액_예외_발생() {
        int invalidAmount = -10000;
        assertThatThrownBy(() -> PurchaseMoneyValidator.validatePositive(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 양수_금액_정상() {
        int validAmount = 10000;
        PurchaseMoneyValidator.validatePositive(validAmount);
    }
}