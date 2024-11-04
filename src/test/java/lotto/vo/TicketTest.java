package lotto.vo;

import lotto.model.MainNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static lotto.common.Constants.*;

public class TicketTest {
    @Test
    void 로또_발행_테스트() {
        Ticket ticket = new Ticket();
        List<Integer> ticketValues = ticket.getTicket();

        assertEquals(MAIN_NUMBER_SIZE, ticketValues.size());
        assertTrue(ticketValues.stream().allMatch(num -> num >= RANGE_START && num <= RANGE_END));
    }
}
