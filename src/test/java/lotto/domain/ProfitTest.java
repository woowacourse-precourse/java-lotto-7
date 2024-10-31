package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    void 수익률은_잘나와야_한다() {
        //given
        Profit profit = new Profit(BigInteger.valueOf(8000));

        //when
        Double profitRate = profit.calculateReturnRate(BigInteger.valueOf(5000));

        //then
        assertThat(profitRate).isEqualTo(62.5);
    }

    @Test
    void 수익률_계산_반올림() {
        //given
        Profit profit = new Profit(BigInteger.valueOf(10000));

        //when
        Double profitRate = profit.calculateReturnRate(BigInteger.valueOf(8234));

        //then
        assertThat(profitRate).isEqualTo(82.3);
    }

}
