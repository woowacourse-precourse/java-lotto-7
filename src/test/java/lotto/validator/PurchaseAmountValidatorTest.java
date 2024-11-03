package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.message.ErrorMessage;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    @Test
    void 구입_금액_없는_경우_예외_테스트() {
        String input = "";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.IS_EMPTY.getMessage());
    }

    @Test
    void 구입_금액_숫자가_아닌_경우_예외_테스트() {
        String input = "6f";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC.getMessage());
    }

    @Test
    void 구입_금액_양수가_아닌_경우_예외_테스트() {
        String input = "0";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE.getMessage());
    }

    @Test
    void 구입_금액_1000원_단위가_아닌_경우_예외_테스트() {
        String input = "1234";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_PRICE_UNITS.getMessage());
    }
}