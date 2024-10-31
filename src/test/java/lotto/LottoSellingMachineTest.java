package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellingMachineTest {

    @DisplayName("1000원을 넣으면 로또 1개를 생성한다")
    @Test
    void createOneLottoWhenInputMoney1000() {
        long money = 1000;
        Lottos lottos = LottoSellingMachine.sell(money);
        assertEquals(1, lottos.getSize());
    }

    @DisplayName("2000원을 넣으면 로또 2개를 생성한다")
    @Test
    void createTwoLottosWhenInputMoney2000() {
        long money = 2000;
        Lottos lottos = LottoSellingMachine.sell(money);
        assertEquals(2, lottos.getSize());
    }

    @DisplayName("1000원 단위가 아닌 금액이 입력되면 예외가 발생한다")
    @Test
    void throwExceptionWhenInputMoneyIsNotUnitOf1000() {
        long money = 1500;
        assertThrows(IllegalArgumentException.class,
                () -> LottoSellingMachine.sell(money));
    }

    @DisplayName("1000원 미만의 금액이 입력되면 예외가 발생한다")
    @Test
    void throwExceptionWhenInputMoneyIsLessThan1000() {
        long money = 500;
        assertThrows(IllegalArgumentException.class,
                () -> LottoSellingMachine.sell(money));
    }
}
