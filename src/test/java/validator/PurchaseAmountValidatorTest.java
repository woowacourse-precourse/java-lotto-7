package validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("구입 금액이 0원 이상이고 1,000원 단위이며, 최대 금액을 초과하지 않을 때 예외가 발생하지 않는다.")
    void 정상_구입_금액이기_때문에_예외가_발생하지_않는다() {
        // given
        BigDecimal validPurchaseAmount = new BigDecimal("5000");

        // when, then
        assertThatCode(() -> PurchaseAmountValidator.validatePurchaseAmount(validPurchaseAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구입 금액이 음수일 때 예외가 발생한다.")
    void 구입_금액이_음수여서_예외가_발생한다() {
        // given
        BigDecimal invalidPurchaseAmount = new BigDecimal("-1000");

        // when, then
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 최대 금액(100,000원)을 초과할 때 예외가 발생한다.")
    void 구입_금액이_최대_금액을_초과해서_예외가_발생한다() {
        // given
        BigDecimal invalidPurchaseAmount = new BigDecimal("101000");

        // when, then
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아닐 때 예외가 발생한다.")
    void 구입_금액이_천_원_단위가_아니어서_예외가_발생한다() {
        // given
        BigDecimal invalidPurchaseAmount = new BigDecimal("1500");

        // when, then
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
