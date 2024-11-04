package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LotteryMachineTest {

    LotteryMachine machine = new LotteryMachine();

    @Test
    void 구입_금액으로_로또_티켓의_올바른_갯수를_반환하는지_테스트() {
        int price = 5000;
        assertEquals(5,machine.countTickets(price));
    }

    @Test
    void 제대로_된_로또_번호를_반환하는지_테스트() {
        Lotto lotto = machine.generateMyLotto();
        assertEquals(6, lotto.getNumbers().size());
        assertTrue(lotto.getNumbers().stream().distinct().count() == 6);    // 모든 번호는 겹치지 않아야 한다
    }
}
