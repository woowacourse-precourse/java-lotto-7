package lotto.util.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PurchasePriceValidatorTest {
    @Test
    void 구입_금액이_1000으로_나누어_떨이지지_않으면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PurchasePriceValidator().validatePurchasePrice(1001));
        assertEquals("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.", exception.getMessage());
    }
}
