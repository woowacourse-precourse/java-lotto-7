package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("LottoTicket 은 주어진 갯수만큼 로또를 발행한다")
    @Test
    void test1() {
        LottoTicket lottoTicket = new LottoTicket();

        List<Lotto> lottos = lottoTicket.create(3);

        assertThat(lottos).hasSize(3);
    }
}
