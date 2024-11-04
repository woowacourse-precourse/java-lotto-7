package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.purchase.PurchaseAmountValidator;
import lotto.utils.Constants;
import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator purchaseAmountValidator;

    @BeforeEach
    void setUp() {
        this.purchaseAmountValidator = new PurchaseAmountValidator(Constants.LOTTO_PRICE);
    }

    @Test
    void 로또_가격의_배수가_아닌_금액일_때_예외_발생() {
        int amount = 1111;
        assertThatThrownBy(() -> purchaseAmountValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_MULTIPLE_OF_PRICE);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    void 구매_금액이_양수가_아니면_예외_발생(int amount) {
        assertThatThrownBy(() -> purchaseAmountValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_POSITIVE_PURCHASE_AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(ints = {Constants.LOTTO_PRICE, Constants.LOTTO_PRICE * 2, Constants.LOTTO_PRICE * 10})
    void 로또_가격의_배수이면_예외가_발생하지_않는다(int amount) {
        assertThatCode(() -> purchaseAmountValidator.validate(amount))
                .doesNotThrowAnyException();
    }
}
