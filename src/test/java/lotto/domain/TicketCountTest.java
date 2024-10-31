package lotto.domain;

import static lotto.domain.PurchaseAmount.LOTTO_PRICE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketCountTest {

    @Test
    void 금액에_알맞는_로또_티켓을_구매한다() {
        // given
        int purchaseAmount = 5000;

        // when
        TicketCount ticketCount = new TicketCount(purchaseAmount);

        // then
        Assertions.assertThat(ticketCount.getCount())
                .isEqualTo(purchaseAmount / LOTTO_PRICE);
    }
}