package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static lotto.domain.constant.LottoRule.TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    Money ticket_price = Money.from(TICKET_PRICE.getNumber());

    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 1500, 1900})
    void 단위가_1000원이_아닌_값이_들어오면_true를_반환한다(int amount) {
        //given
        Money savingMoney = Money.from(amount);
        //when
        //then
        assertThat(savingMoney.isNotMultipleOf(ticket_price)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 15000, 50000})
    void 단위가_1000원인_값이_들어오면_false를_반환한다(int amount) {
        //given
        Money savedMoney = Money.from(amount);
        //when
        //then
        assertThat(savedMoney.isNotMultipleOf(ticket_price)).isFalse();
    }

    @Test
    void 돈을_원하는_금액만큼_더할_수_있다() {
        //given
        Money savedMoney = Money.from(1000);
        Money plusMoney = Money.from(1000);
        Money expectedMoney = Money.from(2000);
        //when
        Money balanceMoney = savedMoney.plus(plusMoney);
        //then
        assertThat(balanceMoney).isEqualTo(expectedMoney);
    }

    @Test
    void 구매금액을_티켓_가격으로_나눌_수_있다() {
        //given
        Money money = Money.from(41000);
        //when
        int result = money.divideBy(ticket_price).toIntValue();
        //then
        assertThat(result).isEqualTo(41);

    }

    @Test
    void 당첨_금액을_구입한_금액만큼_나누어_반올림한다() {
        //given
        Money money = Money.from(1500000);
        //when
        BigDecimal result = money.divideWithRoundHalfUp(ticket_price);
        //then
        assertThat(result).isEqualTo(new BigDecimal("1500.0000"));
    }

    @Test
    void 금액이_비교할_금액보다_작다() {
        //given
        Money money = Money.from(1499999);
        Money compareMoney = Money.from(1500000);
        //when
        //then
        assertThat(money.isLessThan(compareMoney)).isTrue();
    }

    @Test
    void  금액이_비교할_금액보다_크다() {
        //given
        Money money = Money.from(2000);
        Money compareMoney = Money.from(1999);
        //when
        //then
        assertThat(money.isGreaterThan(compareMoney)).isTrue();
    }
}