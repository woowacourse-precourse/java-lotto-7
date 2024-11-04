package lotto.model;

import lotto.vo.Payment;
import lotto.vo.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketManagerTest {
    private TicketManager ticketManager;

    @BeforeEach
    void 객체_생성() {
        Payment payment = new Payment("8000");
        ticketManager = new TicketManager(payment);
    }

    @Test
    void 티켓_장수_계산() {
        assertEquals(8, ticketManager.getTicketAmount());
    }

    @Test
    void 티켓_발행() {
        assertEquals(8, ticketManager.getTickets().size());
    }
}
