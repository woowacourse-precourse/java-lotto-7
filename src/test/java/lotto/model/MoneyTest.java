package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("입력받은 구입 금액에 맞는 구입 숫자를 반환하는지 테스트")
    void purchaseTicket(){
        // TODO : chaining 너무 심하지 않나?
        assertThat(Money.of(8000).toTickets().ticketCount()).isEqualTo(8);
        assertThat(Money.of(100000).toTickets().ticketCount()).isEqualTo(100);
        assertThat(Money.of(5000).toTickets().ticketCount()).isEqualTo(5);
    }
}