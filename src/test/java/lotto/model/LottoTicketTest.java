package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 로또_티켓_생성_테스트() {
        //given
        int ticketCount  = 10;
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(ticketCount, () -> nums);

        //when
        List<Lotto> ticket = lottoTicket.getLottoTicket();

        //then
        assertEquals(ticket.size(), ticketCount);
    }
}