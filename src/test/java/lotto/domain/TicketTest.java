package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @DisplayName("금액만큼 티켓 수를 구입한다.")
    @Test
    void 금액만큼_티켓수를_구입한다() {
        Money money = new Money(8000);
        assertThat(money.getTicket()).isEqualTo(8);
    }
}
