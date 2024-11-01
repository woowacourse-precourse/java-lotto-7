package lotto.domain.ticket;

import java.util.List;
import lotto.global.common.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class TicketsTest {

    private final static int TICKETS_SIZE = 10;

    private final Ticket winningTicket = Ticket.of(List.of(1, 2, 3, 4, 5, 6), 7);

    @Test
    void 각_티켓들의_결과_확인() {
        //given
        Tickets tickets = Tickets.of(TICKETS_SIZE);

        //when
        List<Rank> ticketsResults = tickets.getTicketsResult(winningTicket);
        System.out.println(ticketsResults);
        System.out.println(tickets);

        //then
        Assertions.assertThat(ticketsResults).containsAnyOf(Rank.values());
    }
}