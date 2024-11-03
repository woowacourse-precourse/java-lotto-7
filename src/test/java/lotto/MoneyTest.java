package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("로또 구입 금액이 1장의 가격보다 낮으면 예외를 반환한다")
    @Test
    void test1() {
        Assertions.assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1장의 가격 단위가 아니라면 예외를 반환한다")
    @Test
    void test2() {
        Assertions.assertThatThrownBy(() -> new Money(1999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1장의 가격에 맞추어 로또 갯수를 반환한다")
    @Test
    void test3() {
        Money money = new Money(10000);

        int quantity = money.calculateLottoQuantity();

        Assertions.assertThat(quantity).isEqualTo(10);
    }
}
