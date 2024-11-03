package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {
    @Test
    void 로또_구매_금액이_유효한_경우() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.issueLottos(5000);

        assertEquals(5, lottos.size());
    }
}
