package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void 입력된돈에숫자가아닌값이들어갔을경우() {
        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class,()->new Money("8000j"));
    }

    @Test
    void 보유중인금액조회() {
        // given
        Money money = new Money("8000");

        // when
        System.out.println("=====Logic Start=====");
        System.out.println("=====Logic End=====");
        // then
        assertThat(money.getPrice()).isEqualTo(8000);
    }

    @Test
    void 가지고있는금액을주어진단위로나누는기능() {
        // given
        Money money = new Money("8000");

        // when
        System.out.println("=====Logic Start=====");

        Long actual = money.divideByUnit(1000L);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(8);
    }
    @Test
    void 가지고있는금액을주어진단위로나눠지지않을때예외테스트() {
        // given
        Money money = new Money("8001");

        // when
        // then
        assertThrows(IllegalArgumentException.class,()->money.divideByUnit(1000L));
    }
}