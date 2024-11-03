package lotto.domain.amount;

import static lotto.infrastructure.exception.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseAmount 클래스 테스트")
class PurchaseAmountTest {

    @Test
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않는다면_예외를_발생한다() {
        // given
        String purchaseAmount = "10002";

        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_PURCHASE_AMOUNT.getMessage());
    }
}