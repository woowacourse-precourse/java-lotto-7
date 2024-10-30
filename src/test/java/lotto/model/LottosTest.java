package lotto.model;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest {
    Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
    }

    @Test
    void 로또_구입_개수를_계산한다() {
        String purchaseAmount = "5000";
        lottos.calculateLottoPurchaseCount(purchaseAmount);

        assertThat(lottos.getLottoPurchaseCount())
                .isEqualTo(5);
    }

    @Test
    void 구입금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        String purchaseAmount = "5050";

        assertThatThrownBy(() ->
                lottos.calculateLottoPurchaseCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION.message());
    }
}
