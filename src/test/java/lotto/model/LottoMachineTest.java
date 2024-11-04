package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void 로또_0개_생성() {
        List<Lotto> purchasedLottos = lottoMachine.generateLotto(0);
        assertEquals(0, purchasedLottos.size());
    }

    @Test
    void 로또_1개_생성() {
        List<Lotto> purchasedLottos = lottoMachine.generateLotto(1);
        assertEquals(1, purchasedLottos.size());
    }

    @Test
    void 로또_2개_생성() {
        List<Lotto> purchasedLottos = lottoMachine.generateLotto(2);
        assertEquals(2, purchasedLottos.size());
    }
}
