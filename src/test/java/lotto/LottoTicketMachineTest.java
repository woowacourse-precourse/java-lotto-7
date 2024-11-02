package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoTicketMachine;
import org.junit.jupiter.api.Test;

public class LottoTicketMachineTest {
    private final LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();

    @Test
    void 구매금액에_따라_올바른_수의_로또를_구매한다() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = lottoTicketMachine.purchaseLottoTickets(purchaseAmount);

        assertEquals(5, lottos.size());
    }
}
