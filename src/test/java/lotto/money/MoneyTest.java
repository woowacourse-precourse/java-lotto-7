package lotto.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    private final Money ONE = new Money(1);
    private final Money TWO = new Money(2);
    private final Money THREE = new Money(3);
    private final Money FOUR = new Money(4);
    private final Money FIVE = new Money(5);
    private final Money SIX = new Money(6);
    private final Money NINE = new Money(9);

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

    @DisplayName("돈의 비율을 퍼센트 단위로 구할 수 있음")
    @Test
    void test6() {
        assertEquals(FOUR.rateAsPercent(ONE), 400);
        assertEquals(FIVE.rateAsPercent(ONE), 500);
        assertEquals(SIX.rateAsPercent(TWO), 300);

        assertEquals(ONE.rateAsPercent(FIVE), 20);
        assertEquals(ONE.rateAsPercent(FOUR), 25);
        assertEquals(THREE.rateAsPercent(FOUR), 75);
    }

    @DisplayName("비율은 퍼센트 소수점 두 번째 자리에서 반올림됨")
    @Test
    void test7() {
        assertEquals(THREE.rateAsPercent(NINE), 33.3);
        assertEquals(SIX.rateAsPercent(NINE), 66.7);
    }
}