package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    @DisplayName("입력받은 구입 금액에 맞는 구입 숫자를 반환하는지 테스트")
    void purchaseTicket(){
        assertThat(Ticket.purchaseTickets(8000).getTicketCount()).isEqualTo(8);
        assertThat(Ticket.purchaseTickets(100000).getTicketCount()).isEqualTo(100);
        assertThat(Ticket.purchaseTickets(5000).getTicketCount()).isEqualTo(5);
    }
}