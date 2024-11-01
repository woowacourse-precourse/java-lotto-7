package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount;

    @Test
    void validateNonThousandDivisibility_1000_으로_나누어떨어진다() {
        // given
        Long number = 5000L;

        // when
        purchaseAmount = new PurchaseAmount(number);

        // then
        Assertions.assertThat(purchaseAmount.purchaseAmount()).isEqualTo(number);
    }

    @Test
    void validateNonThousandDivisibility_1000_으로_나누어떨어지지_않는다() {
        // given
        Long number = 5500L;

        // when
        // then
        assertThatThrownBy(() -> purchaseAmount = new PurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_THOUSAND_DIVISIBILITY);

    }
}