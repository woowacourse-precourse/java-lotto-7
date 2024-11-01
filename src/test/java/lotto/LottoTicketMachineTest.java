package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicketMachine;
import org.junit.jupiter.api.Test;

public class LottoTicketMachineTest {

    @Test
    void 구매할_로또_장수를_계산합니다() {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        assertEquals(3, lottoTicketMachine.calculateLottoCount(3000));
        assertEquals(5, lottoTicketMachine.calculateLottoCount(5000));
    }

    @Test
    void 로또를_구매할_장수에_맞게_발행합니다() {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        List<Lotto> lottos = lottoTicketMachine.generateLottoTickets(5);

        assertEquals(5, lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            assertEquals(6, lottoNumbers.size());
        }
    }
}
