package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    void 입력한_금액만큼_구매한_로또티켓을_생성한다() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.purchaseTicket(5000);

        assertEquals(5, lottoTicket.getLottos().size());
    }

}
