package lotto.validator;

import static lotto.validator.ValidatorUtils.PURCHASE_AMOUNT_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountValidatorTest {

    private PurchaseAmountValidator purchaseAmountValidator;

    @BeforeEach
    void setUp() {
        purchaseAmountValidator = new PurchaseAmountValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    void 유효한_구입금액_검사(int purchaseAmount) {
        assertThatCode(() -> purchaseAmountValidator.validate(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 1001, 1500})
    void 유효하지않은_구입금액_검사(int purchaseAmount) {
        assertThatThrownBy(() -> purchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_ERROR_MESSAGE);
    }
}
