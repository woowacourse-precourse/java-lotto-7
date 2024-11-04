package lotto.purchase.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("Money 생성 테스트")
    void moneyCreate() {
        Money money = Money.of(1000);
        Assertions.assertThat(money).isInstanceOf(Money.class);
    }

    @Test
    @DisplayName("Money 생성 인자가 음수로 들어오면 예외를 터뜨린다.")
    void throwExceptionWhenMoneyIsNegative() {
        Assertions.assertThatThrownBy(() -> Money.of(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money 생성 인자가 1000원보다 작게 들어오면 예외를 터뜨린다.")
    void throwExceptionWhenMoneyIsLessThan1000() {
        Assertions.assertThatThrownBy(() -> Money.of(500)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money 생성 인자가 1000원 단위가 아니면 예외를 터뜨리다")
    void throwExceptionWhenMoneyIsNot1000unit() {
        Assertions.assertThatThrownBy(() -> Money.of(1500)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈에 따라 로또 갯수가 결정된다")
    void calculateLottoQuantityByMoney() {
        // given
        Money money = Money.of(8000);

        // when
        long quantitiesCanBuy = money.getQuantitiesCanBuy();

        // then
        Assertions.assertThat(quantitiesCanBuy).isEqualTo(8);
    }

    @Test
    @DisplayName("획득 금액의 수익률을 계산한다")
    void calculateLottoIncome() {
        // given
        Money money = Money.of(8000);
        long income = 5000;

        // when
        double rate = money.calculateRateOfIncome(income);

        // then
        Assertions.assertThat(rate).isEqualTo(62.5);
    }
}