package lotto.domain;

import static lotto.global.Error.MONEY_NOT_DIVISIBLE_1000;
import static lotto.global.Error.MONEY_NOT_POSITIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Buy;
import org.junit.jupiter.api.Test;

public class BuyTest {

    @Test
    void 지불액_양수가_아닐시_예외_발생() {
        int money = -3;
        assertThatThrownBy(() -> new Buy(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_NOT_POSITIVE.getErrorMsg());
    }

    @Test
    void 구매가격이_1000으로_나누어_떨어지지_않을시_예외_발생() {
        int money = 1500;
        assertThatThrownBy(() -> new Buy(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_NOT_DIVISIBLE_1000.getErrorMsg());
    }

    @Test
    void 티켓_갯수_계산() {
        int money = 5000;
        Buy buy = new Buy(money);
        buy.calculateLottoCounts();

        assertEquals(buy.getLottoCounts(), 5);
    }
}
