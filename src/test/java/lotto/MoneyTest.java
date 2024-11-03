package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static lotto.constant.ErrorMessage.PURCHASE_PRICE_ERROR;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("로또 금액과 나머지 연산한 결과가 0이 아니면 예외가 발생한다.")
    void noneFitPurchase() {
        //given
        long amount = 12500;

        //when //then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_PRICE_ERROR.getMessage());
    }
}