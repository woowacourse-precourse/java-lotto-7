package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {
    @Test
    void 로또_티켓_생성_성공()
    {
        LottoTickets tickets=new LottoTickets(5);
        Assertions.assertThat(tickets.getTickets()).hasSize(5);
    }
}
