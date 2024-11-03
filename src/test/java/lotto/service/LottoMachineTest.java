package lotto.service;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import lotto.domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 로또_티켓_발급(){
        int price = 10000;
        LottoTicket ticket = new LottoTicket(price);

        LottoMachine machine = new LottoMachine(ticket);
        List<Lotto> lottos = machine.getLottos();

        assertThat(lottos).hasSize(ticket.getCount());
    }


}

