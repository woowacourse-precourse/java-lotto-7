package lotto.domain;

import lotto.error.CostErrorMessage;
import lotto.error.NumberErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CostTest {

    @Test
    void 구매비용은_문자를_포함할_수_없다() {
        //given
        String cost = "1000원";

        //when & then
        assertThatThrownBy(() -> new Cost(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 구매비용은_최소한_천원이어야한다() {
        // given
        String cost = "10";

        //when & then
        assertThatThrownBy(() -> new Cost(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CostErrorMessage.INSUFFICIENT_MONEY.getMessage());
    }

    @Test
    void 구매비용은_최대_백만원이다() {
        // given
        String cost = "2000000";

        //when & then
        assertThatThrownBy(() -> new Cost(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CostErrorMessage.TOO_MANY_MONEY.getMessage());
    }

    @Test
    void 구매비용은_1000으로_나눠져야한다() {
        //given
        String cost = "10001";

        //when & then
        assertThatThrownBy(() -> new Cost(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CostErrorMessage.CAN_NOT_DIVIDED.getMessage());
    }

    @Test
    void 정상_테스트() {
        //given
        String cost = "20000";

        //when & then
        assertThatCode(() -> new Cost(cost))
                .doesNotThrowAnyException();
    }
}