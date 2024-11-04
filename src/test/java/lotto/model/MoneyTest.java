package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구입 금액 테스트")
class MoneyTest {
    @ParameterizedTest
    @CsvSource({"8000,8", "100000,100", "5000,5"})
    @DisplayName("입력받은 구입 금액에 맞는 구입 숫자를 반환하는지 테스트")
    void purchaseTicket(int amount, int ticketCount) {
        Ticket ticket = Money.of(amount).toTickets();
        assertThat(ticket.ticketCount()).isEqualTo(ticketCount);
    }
}