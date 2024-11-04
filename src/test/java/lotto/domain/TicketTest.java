package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TicketTest {

    @ParameterizedTest
    @DisplayName("올바른 티켓 갯수를 반환한다.")
    @ValueSource(ints = {1000, 3000, 5000, 10000, 99000})
    void 올바른_티켓_갯수를_반환한다(int target) {
        Money money = new Money(target);
        Ticket ticket = Ticket.of(money);
        assertThat(ticket.getTicket()).isEqualTo(target / 1_000);
    }
}
