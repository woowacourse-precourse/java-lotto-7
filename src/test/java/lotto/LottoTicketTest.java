package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 로또_티켓_발행() {
        assertSimpleTest(
                () -> {
                    LottoTicket ticket = LottoTicket.of(3);
                    assertThat(ticket.getTicket().size()).isEqualTo(3);
                }
        );
    }

}
