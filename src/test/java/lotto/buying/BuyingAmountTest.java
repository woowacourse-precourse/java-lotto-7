package lotto.buying;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyingAmountTest {

    @Test
    @DisplayName("로또의 구입금액은 최소 천원이다")
    void lessThanMinimumAmountThrowEException() {
        // given
        int lessNumber = 900;

        // when then
        assertThatThrownBy(() -> BuyingAmount.from(lessNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액이 천원 미만입니다.");
    }

    @Test
    @DisplayName("로또는 천원 단위로만 구입한다")
    void notAmountUnitThrowException() {
        // given
        int notUnit = 1550;

        // when then
        assertThatThrownBy(() -> BuyingAmount.from(notUnit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 천원 단위여야 합니다.");
    }
}
