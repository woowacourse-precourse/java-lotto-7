package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount;

    @ParameterizedTest
    @ValueSource(longs = {0L, 1000L, (Long.MAX_VALUE - Long.MAX_VALUE % 1000)})
    void 모든_검증에_통과하여_정상적으로_생성된다(Long number) {
        // given

        // when
        purchaseAmount = new PurchaseAmount(number);

        // then
        Assertions.assertThat(purchaseAmount.purchaseAmount()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 500L, 5500L, 231241L})
    void validateLottoPriceDivisibility_1000_으로_나누어떨어지지_않는다(Long number) {
        // given

        // when
        // then
        assertThatThrownBy(() -> purchaseAmount = new PurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_LOTTO_PRICE_DIVISIBILITY);

    }

    @ParameterizedTest
    @ValueSource(longs = {-1000L, -1000000L, (Long.MIN_VALUE - Long.MIN_VALUE % 1000)})
    void validateNegative_구입금액은_음수가_될_수_없다(Long number) {
        // given

        // when
        // then
        assertThatThrownBy(() -> purchaseAmount = new PurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_NOT_NEGATIVE);

    }
}