package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private PurchaseAmountValidator validator;

    @Test
    void purchaseAmountNegativeTest() {
        long negativeAmount = -1000;
        validator = new PurchaseAmountValidator(negativeAmount);
        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void purchaseAmountNotMultipleOfThousandTest() {
        long notMultipleOfThousand = 1300;
        validator = new PurchaseAmountValidator(notMultipleOfThousand);
        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void purchaseAmountOverLimitTest() {
        long overLimit = 4611687000L;
        validator = new PurchaseAmountValidator(overLimit);
        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}
