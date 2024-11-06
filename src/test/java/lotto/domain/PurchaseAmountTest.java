package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_NOT_ENOUGH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("구매 금액 테스트")
class PurchaseAmountTest {
    @DisplayName("구매 금액이 1000원 미만일 경우 예외를 발생시킨다.")
    @Test
    void 구매_금액이_1000원_미만일_경우_예외를_발생시킨다() {
        // given
        int amount = 999;

        // when, then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_ENOUGH.getMessage());
    }

    @DisplayName("구매 금액이 1000원으로 나누어 떨어지지 않을 경우 예외를 발생시킨다.")
    @Test
    void 구매_금액이_1000원으로_나누어_떨어지지_않을_경우_예외를_발생시킨다() {
        // given
        int amount = 1500;

        // when, then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_DIVISIBLE.getMessage());
    }
}
