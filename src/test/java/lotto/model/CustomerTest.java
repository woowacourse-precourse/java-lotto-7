package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.util.List;
import lotto.model.customer.Customer;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    @DisplayName("올바른 수익률을 반환한다.")
    void returnValidProfitRate() {
        // given
        int paidAmount = 8_000;
        List<LottoTicket> lottoTickets = List.of(new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Customer customer = new Customer(paidAmount, lottoTickets);
        lottoTickets.forEach(lottoTicket -> lottoTicket.determineRank(
                (new WinningLotto(new Lotto(List.of(1, 2, 3, 9, 10, 11)), 12))));

        // when
        double profitRate = customer.calculateProfitRate();

        // then
        assertThat(profitRate).isCloseTo(62.5, offset(0.1));
    }
}

