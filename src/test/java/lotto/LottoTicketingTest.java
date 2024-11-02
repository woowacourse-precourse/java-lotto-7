package lotto;

import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.service.LottoTicketing;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketingTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "100000,100"})
    void 정해진_수만큼_티켓을_발권한다(int price, int count) {

        Purchase purchase = new Purchase(price);

        LottoTicketing lottoTicketing = new LottoTicketing();
        Lottos lottos = lottoTicketing.issueTickets(purchase);
        assertThat(lottos.getTickets().size()).isEqualTo(count);
    }
}