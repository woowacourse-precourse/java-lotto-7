package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount;

    @Test
    void 모든_검증에_통과하여_정상적으로_생성된다() {
        // given
        Long number = 5000L;

        // when
        purchaseAmount = new PurchaseAmount(number);

        // then
        Assertions.assertThat(purchaseAmount.purchaseAmount()).isEqualTo(number);
    }

    @Test
    void validateLottoPriceDivisibility_1000_으로_나누어떨어지지_않는다() {
        // given
        Long number = 5500L;

        // when
        // then
        assertThatThrownBy(() -> purchaseAmount = new PurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_LOTTO_PRICE_DIVISIBILITY);

    }

    @Test
    void validateNegative_구입금액은_음수가_될_수_없다() {
        // given
        Long number = -1000L;

        // when
        // then
        assertThatThrownBy(() -> purchaseAmount = new PurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_NOT_NEGATIVE);

    }
}