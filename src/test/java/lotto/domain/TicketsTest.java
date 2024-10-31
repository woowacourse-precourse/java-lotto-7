package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketsTest {

    @Test
    void 구입금액_만큼의_로또를_발급한다() {
        // given
        TicketCount ticketCount = new TicketCount(10000);

        // when
        Tickets tickets = new Tickets(ticketCount);

        // then
        Assertions.assertThat(tickets.getSize()).isEqualTo(10);
    }
}