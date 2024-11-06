package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    private LottoTickets lottoTickets;

    @Test
    @DisplayName("구입 금액을 입력하였을 때 해당하는 매수만큼 로또가 구매된다.")
    void 희망_매수만큼_로또_구매_확인() {
        int amount = 8000;
        lottoTickets = new LottoTickets(LottoGenerator.makeTickets(amount / 1000));

        assertThat(lottoTickets.getTickets().size()).isEqualTo(amount / 1000);
    }
}
