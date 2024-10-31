package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {

    @DisplayName("10_000이 입력되었을 경우, 10개의 티켓이 생성된다.")
    @Test
    void buy_ticket_test() {
        int purchaseAmount = 10_000;

        Ticket ticket = new Ticket(purchaseAmount);
        assertThat(ticket.getQuantity()).isEqualTo(10);
    }

    @DisplayName("1000이 입력되었을 경우, 1개의 티켓이 생성된다.")
    @Test
    void buy_ticket_1000_test() {
        int purchaseAMount = 1000;

        Ticket ticket = new Ticket(purchaseAMount);
        assertThat(ticket.getQuantity()).isEqualTo(1);
    }

}
