package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineImplTest {
    private static final int LOTTO_NUMBER = 6;
    private static final LottoMachineImpl lottoMachine = new LottoMachineImpl();

    @Test
    void 발행할_개수를_입력하면_로또가_6개씩_발행_개수만큼_생성된다() {
        //given
        int count = 5;
        //when
        List<Lotto> lottoTickets = lottoMachine.createLottoTickets(count);
        //then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(count);
        Assertions.assertThat(lottoTickets.get(1).getNumbers().size()).isEqualTo(LOTTO_NUMBER);
    }
}