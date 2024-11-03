package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private PurchaseAmountValidator validator;

    @ParameterizedTest
    @ValueSource(longs = {-1000, 1300, 4611687000L})
    void purchaseAmountValidateTest(long value) {
        validator = new PurchaseAmountValidator(value);
        assertThatThrownBy(() -> validator.validate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}
