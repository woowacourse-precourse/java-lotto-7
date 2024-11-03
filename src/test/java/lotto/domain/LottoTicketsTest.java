package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    void 정상입력() {
        // given
        String money = "8000";

        // when
        LottoTickets lottoTickets = new LottoTickets(money);

        // then
        List<Lotto> lottos = lottoTickets.getLottos();

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.getAmount()).isEqualTo(8);
        assertThat(lottos).hasSize(8);
    }

}