package lotto.model;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {
    LottoPurchase lottoPurchase;

    @BeforeEach
    void init() {
        lottoPurchase = new LottoPurchase();
    }

    @Test
    void 로또_구입_개수를_계산한다() {
        long purchaseAmount = 5000L;
        lottoPurchase.calculateLottoPurchaseCount(purchaseAmount);

        assertThat(lottoPurchase.getLottoPurchaseCount())
                .isEqualTo(5);
    }

    @Test
    void 구입금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        long purchaseAmount = 5050L;

        assertThatThrownBy(() ->
                lottoPurchase.calculateLottoPurchaseCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION.message());
    }
}
