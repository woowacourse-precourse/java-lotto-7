package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProfitTest {
    @Test
    void 로또_10장을_구매하고_그_중_5000원이_당첨되면_수익률은_50퍼센트이다() {
        //given
        //when
        Profit profit = new Profit(10000, 5000);
        //then
        Assertions.assertThat(profit.toString()).isIn("50.0");
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -1000})
    void 금액이_0또는_음수이면_예외가_발생한다(int invalidAmount) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Profit(invalidAmount, 5000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -100_000_000})
    void 총보상금액이_음수이면_예외가_발생한다(int invalidTotalReward) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Profit(1000, invalidTotalReward))
                .isInstanceOf(IllegalArgumentException.class);
    }
}