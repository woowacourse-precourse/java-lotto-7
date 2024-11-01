package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("갯수에 맞게 로또를 발행한다")
    @Test
    void 갯수에_맞게_로또를_발행한다() {
        LottoTickets lottoTickets = new LottoTickets(8);

        assertThat(lottoTickets.getLottoTickets()).hasSize(8);
    }
}