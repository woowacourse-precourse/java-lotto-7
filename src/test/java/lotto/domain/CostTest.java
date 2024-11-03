package lotto.domain;

import lotto.error.CostErrorMessage;
import lotto.error.NumberErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CostTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000원", "1000j", "1000."})
    void 구매비용은_문자를_포함할_수_없다(String cost) {
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
        String cost = "1000001";

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

    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "1000000"})
    void 정상_테스트(String cost) {
        //when & then
        assertThatCode(() -> new Cost(cost))
                .doesNotThrowAnyException();
    }
}