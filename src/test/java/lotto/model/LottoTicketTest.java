package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    void 로또_티켓에_로또가_정상적으로_저장되는지_확인한다() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoTicket ticket = new LottoTicket(Arrays.asList(lotto1, lotto2), 2000);

        assertEquals(2, ticket.getLottos().size());
        assertTrue(ticket.getLottos().contains(lotto1));
        assertTrue(ticket.getLottos().contains(lotto2));
    }
}
