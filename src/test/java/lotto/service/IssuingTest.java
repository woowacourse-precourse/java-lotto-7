package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuingTest {
    @Test
    void 로또_티켓_발급() {
        LottoTicket ticket = new LottoTicket(7000);

        Issuing.lottoTickets(ticket);
        List<Lotto> lottos = ticket.getLottoTickets();

        assertThat(lottos).hasSize(ticket.getCount());
    }


}

