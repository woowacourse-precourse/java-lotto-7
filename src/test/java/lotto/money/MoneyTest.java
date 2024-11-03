package lotto.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    private final Money ONE = new Money(1);
    private Money TWO = new Money(2);
    private final Money FOUR = new Money(4);
    private final Money FIVE = new Money(5);
    private final Money SIX = new Money(6);

    @DisplayName("돈은 마이너스가 불가능함")
    @Test
    void test1() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

    @DisplayName("돈을 더할 수 있음")
    @Test
    void test2() {
        assertEquals(ONE.plus(FOUR), FIVE);
        assertEquals(ONE.plus(FIVE), SIX);
    }

    @DisplayName("0 단위로 돈뭉치를 세려고 하면 예외가 발생함")
    @Test
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> FIVE.countBundle(Money.EMPTY));
    }

    @DisplayName("나누어 떨어지지 단위로 돈뭉치를 세려고 하면 예외가 발생함")
    @Test
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> FIVE.countBundle(FOUR));
    }

    @DisplayName("특정 단위로 돈뭉치를 셀 수 있음")
    @Test
    void test5() {
        assertEquals(FOUR.countBundle(ONE), 4);
        assertEquals(FOUR.countBundle(new Money(2)), 2);
    }

    @DisplayName("돈의 비율을 구할 수 있음")
    @Test
    void test6() {
        assertEquals(FOUR.rateAs(ONE), 4);
        assertEquals(FIVE.rateAs(ONE), 5);
        assertEquals(SIX.rateAs(TWO), 3);
    }
}