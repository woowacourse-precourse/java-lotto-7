package lotto.domain.money;

import static lotto.ErrorCode.INVALID_NUMBER_FORMAT;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseAmount 클래스 테스트")
class PurchaseAmountTest {

    @Test
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않는다면_예외를_발생한다() {
        // given
        String purchaseAmount = "10002";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 로또_구입_금액이_숫자가_아니라면_예외를_발생한다() {
        // given
        String purchaseAmount = "1000a";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void 로또_구입_금액이_정수_범위를_벗어나면_예외를_발생한다() {
        // given
        String purchaseAmount = "21474836998";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }


}