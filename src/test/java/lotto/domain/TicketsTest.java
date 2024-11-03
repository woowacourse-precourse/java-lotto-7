package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketsTest {

    @Test
    void 티켓_개수만큼_로또_티켓이_생성된다() {
        // given
        Tickets tickets = new Tickets(5);

        // when & then
        assertThat(tickets.getSize()).isEqualTo(5);
    }

    @Test
    void 티켓_정보를_반환한다() {
        // given
        Tickets tickets = new Tickets(3);

        // when
        List<String> ticketsInfo = tickets.getTicketsInfo();

        // then
        assertThat(ticketsInfo).hasSize(3);
        ticketsInfo.forEach(info -> assertThat(info).matches("\\d+, \\d+, \\d+, \\d+, \\d+, \\d+"));
    }
}