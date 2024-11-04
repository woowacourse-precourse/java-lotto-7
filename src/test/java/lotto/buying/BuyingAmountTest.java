package lotto.buying;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyingAmountTest {

    @Test
    @DisplayName("로또의 구입금액은 최소 천원이다")
    void lessThanMinimumAmountThrowsException() {
        // given
        int lessNumber = 900;

        // when then
        assertThatThrownBy(() -> BuyingAmount.from(lessNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액이 천원 미만입니다.");
    }

    @Test
    @DisplayName("로또는 천원 단위로만 구입한다")
    void notAmountUnitThrowsException() {
        // given
        int notUnit = 1550;

        // when then
        assertThatThrownBy(() -> BuyingAmount.from(notUnit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 천원 단위여야 합니다.");
    }

    @Test
    @DisplayName("로또는 십만원까지만 구입 가능하다")
    void moreThanMaximumAmountThrowsException() {
        // given
        int tooLarge = 200000;

        // when then
        assertThatThrownBy(() -> BuyingAmount.from(tooLarge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입은 한 번에 10만원까지만 가능합니다.");
    }
}
