package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoTicket = new LottoTicket(List.of(lotto));
    }

    @Test
    void 로또_개수를_반환한다() {
        assertThat(lottoTicket.size()).isEqualTo(1);
    }
}