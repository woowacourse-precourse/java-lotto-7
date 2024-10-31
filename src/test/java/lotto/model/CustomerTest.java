package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    @DisplayName("올바른 수익률을 반환한다.")
    void returnValidProfitRate() {
        // given
        int paidAmount = 3_000;
        LottoTicket lottoTicket = new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Customer customer = new Customer(paidAmount, List.of(lottoTicket));
        customer.determineRanks(new WinningLotto(List.of(1, 2, 3, 7, 8, 9), 10));

        // when
        double profitRate = customer.calculateProfitRate();

        // then
        assertThat(profitRate).isCloseTo(66.7, offset(0.1));
    }
}

