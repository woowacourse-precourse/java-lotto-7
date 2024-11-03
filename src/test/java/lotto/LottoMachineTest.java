package lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 금액에_맞게_로또_티켓이_생성된다(){
        LottoMachine lottoMachine = new LottoMachine();
        PurchaseAmount amount = new PurchaseAmount(5000);

        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(amount);

        assertThat(lottoTicket.getLottos()).hasSize(5);
    }
}
