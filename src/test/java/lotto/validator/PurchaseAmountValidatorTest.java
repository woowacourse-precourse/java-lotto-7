package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @Test
    void 구입_금액_검증() {
        String inputAmount = "10000";
        assertThat(validator.isValidPurchaseAmount(inputAmount)).isEqualTo(true);
    }

    @Test
    void 예외_구입_금액_단위_오류() {
        String inputAmount = "10050";
        assertThatThrownBy(() -> validator.isValidPurchaseAmount(inputAmount)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 예외_구입_금액_문자열_입력() {
        String inputAmount = "12a00";
        assertThatThrownBy(() -> validator.isValidPurchaseAmount(inputAmount)).isInstanceOf(
                IllegalArgumentException.class);
    }
}