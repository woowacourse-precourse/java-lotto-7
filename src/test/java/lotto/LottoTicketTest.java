package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("주어진 갯수만큼 로또를 발행한다")
    @Test
    void test1() {
        LottoTicket lottoTicket = new LottoTicket();

        List<Lotto> lottos = lottoTicket.createLotto(3);

        assertThat(lottos).hasSize(3);
    }

    @DisplayName("구입 금액에 해당하는 로또를 발행한다")
    @Test
    void test2() {
        Money money = new Money(10000);
        LottoTicket lottoTicket = new LottoTicket();

        List<Lotto> lottos = lottoTicket.createLotto(money.calculateLottoQuantity());

        assertThat(lottos).hasSize(10);
    }
}
