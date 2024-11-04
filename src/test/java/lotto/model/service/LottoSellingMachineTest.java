package lotto.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellingMachineTest {

    @ParameterizedTest
    @ValueSource(longs = {1000L, 2000L})
    @DisplayName("1000원 단위의 금액을 넣으면 로또 1개를 생성한다")
    void test1(long money) {
        Lottos lottos = new LottoSellingMachine().sell(money);
        assertEquals(money/1000, lottos.getSize());
    }

    @DisplayName("1000원 단위가 아닌 금액이 입력되면 예외가 발생한다")
    @Test
    void test2() {
        long money = 1500;
        assertThrows(IllegalArgumentException.class,
                () -> new LottoSellingMachine().sell(money));
    }

    @DisplayName("1000원 미만의 금액이 입력되면 예외가 발생한다")
    @Test
    void test3() {
        long money = 500;
        assertThrows(IllegalArgumentException.class,
                () -> new LottoSellingMachine().sell(money));
    }
}
