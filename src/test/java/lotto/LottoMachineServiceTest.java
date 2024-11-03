package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.LottoTickets;
import lotto.service.LottoMachineService;
import org.junit.jupiter.api.Test;

public class LottoMachineServiceTest {
    LottoMachineService lottoMachineService = new LottoMachineService();

    @Test
    void 로또_리스트_발행() {
        String purchaseAmount = "8000";
        int expect = 8;
        LottoTickets lottoTickets = lottoMachineService.createLottoTickets(purchaseAmount);
        assertEquals(expect, lottoTickets.size());
    }
}
