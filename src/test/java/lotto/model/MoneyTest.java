package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 유효한_금액이_입력되면_Money_객체가_생성된다() {
        String validMoney = "1000";
        assertThatCode(() -> new Money(validMoney)).doesNotThrowAnyException();
    }

    @Test
    void 숫자가_아닌_것이_입력되면_예외가_발생한다() {
        String invalidMoney = "!";
        assertThatThrownBy(() -> new Money(invalidMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.INVALID_INT_NUMBER.getMessage());
    }

    @Test
    void 금액으로_구매할_수_있는_로또_개수가_올바르게_계산된다() {
        Money money = new Money("15000");
        int expectedQuantity = 15;
        assertThat(money.boughtLottosQuantity()).isEqualTo(expectedQuantity);
    }
}
