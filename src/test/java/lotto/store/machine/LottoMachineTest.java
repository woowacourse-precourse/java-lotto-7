package lotto.store.machine;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.store.user.Cash;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 현금으로_로또를_구매한다() {
        //given
        Cash cash = Cash.from(8000);

        //when
        lottoMachine.purchase(cash);

        //then
        assertThat(lottoMachine.currentLottoTicketCount()).isEqualTo(8);
    }

}
