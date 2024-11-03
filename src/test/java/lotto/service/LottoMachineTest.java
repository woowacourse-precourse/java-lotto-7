package lotto.service;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import lotto.domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    LottoMachine machine = new LottoMachine();
    @Test
    void 로또_티켓_발급(){
        int price = 10000;
        LottoTicket ticket = new LottoTicket(price);


        List<Lotto> lottos = machine.issueLottoTickets(ticket);

        assertThat(lottos).hasSize(ticket.getCount());
    }


}

