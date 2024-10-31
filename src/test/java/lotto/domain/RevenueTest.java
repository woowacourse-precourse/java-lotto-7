package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class RevenueTest {

    @Test
    void 초기금액은_1000으로_나누어떨어지지_않으면_예외를_발생한다() {
        assertThatThrownBy(() -> new Revenue(new Money(BigInteger.valueOf(1234)), new Money(BigInteger.valueOf(0))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률은_잘나와야_한다() {
        //given
        Revenue revenue = new Revenue(new Money(BigInteger.valueOf(8000)), new Money(BigInteger.valueOf(5000)));

        //when
        Double profit = revenue.calculateReturnRate();

        //then
        assertThat(profit).isEqualTo(62.5);
    }


}
