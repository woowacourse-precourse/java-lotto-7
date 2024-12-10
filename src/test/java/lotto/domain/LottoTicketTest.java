package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void from_메서드는_요청된_개수의_LottoTicket을_생성한다() {
        int ticketCount = 5;
        LottoTicket lottoTicket = LottoTicket.from(ticketCount);

        assertThat(lottoTicket.size()).isEqualTo(ticketCount);
    }
}
