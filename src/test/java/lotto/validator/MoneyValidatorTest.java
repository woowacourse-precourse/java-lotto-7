package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @Test
    void 구매_금액_숫자가_아니면_예외_발생() {
        String input = "10j";

        assertThatThrownBy(() -> MoneyValidator.validateMoneyToBuy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 구매_금액_1000원_단위_아니면_예외_발생() {
        String input = "1023";

        assertThatThrownBy(() -> MoneyValidator.validateMoneyToBuy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 구매_금액_양수_아니면_예외_발생() {
        String input = "-1000";

        assertThatThrownBy(() -> MoneyValidator.validateMoneyToBuy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
    }
}
