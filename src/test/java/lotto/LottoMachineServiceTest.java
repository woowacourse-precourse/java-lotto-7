package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoMachineServiceTest {
    LottoMachineService lottoMachineService = new LottoMachineService();

    @Test
    void 발행_수량_계산(){
        int purchaseAmount = 8000;
        int expect = 8;
        int result = lottoMachineService.calculateLottoCount(purchaseAmount);

        assertEquals(expect, result);
    }
    @Test
    void 로또_리스트_발행(){
        int purchaseAmount = 8000;
        int expect = 8;
        LottoTickets lottoTickets = lottoMachineService.createLottoTickets(purchaseAmount);
        assertEquals(expect, lottoTickets.size());
    }
}
