package lotto.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 금액은_음수면_예외를_발생한다() {
        assertThatThrownBy(() -> new Money(BigInteger.valueOf(-1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산() {
        //given
        Money initialInvestment = new Money(BigInteger.valueOf(8000));
        Money totalEarnings = new Money(BigInteger.valueOf(5000));

        //when
        Double profit = totalEarnings.calculateReturnRate(initialInvestment);

        //then
        assertThat(profit).isEqualTo(62.5);
    }

    @Test
    void 수익률_계산_반올림() {
        //given
        Money initialInvestment = new Money(BigInteger.valueOf(10000));
        Money totalEarnings = new Money(BigInteger.valueOf(8234));

        //when
        Double profit = totalEarnings.calculateReturnRate(initialInvestment);

        //then
        assertThat(profit).isEqualTo(82.3);
    }
}
