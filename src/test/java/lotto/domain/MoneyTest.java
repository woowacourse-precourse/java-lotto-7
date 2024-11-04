package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.domain.purchase.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("5000을 1000으로 나눠서 몫을 5로 반환 한다.")
    void calculateQuotientTest() {
        //given
        final Money money = new Money(5000);
        final int number = 1000;

        //when
        final int quotient = money.calculateQuotient(number);

        //then
        assertThat(quotient).isEqualTo(5);
    }

    @Test
    @DisplayName("구입 금액 8000원, 당첨 금액이 5000원 이므로 수익률 62.5를 반환 한다.")
    void calculateRatioTest() {
        //given
        final Money money = new Money(8000);
        final BigDecimal number = BigDecimal.valueOf(5000);

        //when
        final double ratio = money.calculateRatio(number);

        //then
        assertThat(ratio).isEqualTo(62.5);
    }
}
