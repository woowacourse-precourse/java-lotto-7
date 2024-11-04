package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class LottoTicketsTest {

    @Test
    void 로또_티켓의_개수가_구입금액에_따라_올바르게_생성된다() {
        LottoPurchaseMoney purchaseMoney = new LottoPurchaseMoney("3000");
        LottoTickets lottoTickets = new LottoTickets(purchaseMoney);

        assertThat(lottoTickets.getLottoTickets()).hasSize(3);
    }

    @Test
    void 생성된_로또_티켓은_변경할_수_없다() {
        LottoPurchaseMoney purchaseMoney = new LottoPurchaseMoney("2000");
        LottoTickets lottoTickets = new LottoTickets(purchaseMoney);

        List<Lotto> tickets = lottoTickets.getLottoTickets();

        assertThatThrownBy(() -> tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
