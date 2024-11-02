package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    private static final int NUMBER_OF_TICKETS = 8;

    @DisplayName("갯수에 맞게 로또를 발행한다")
    @Test
    void 갯수에_맞게_로또를_발행한다() {
        LottoTickets lottoTickets = new LottoTickets(NUMBER_OF_TICKETS);

        assertThat(lottoTickets.getLottoTickets()).hasSize(NUMBER_OF_TICKETS);
    }
}