package domain;

import static exception.ErrorMessage.PURCHASE_PRICE_DIVIDE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TicketTest {

    @DisplayName("10_000이 입력되었을 경우, 10개의 티켓이 생성된다.")
    @Test
    void buy_ticket_test() {
        int purchaseAmount = 10_000;

        Ticket ticket = new Ticket(purchaseAmount);
        assertThat(ticket.getQuantity()).isEqualTo(10);
    }

    @DisplayName("1000이 입력되었을 경우, 1개의 티켓이 생성된다.")
    @Test
    void buy_ticket_1000_test() {
        int purchaseAmount = 1000;

        Ticket ticket = new Ticket(purchaseAmount);
        assertThat(ticket.getQuantity()).isEqualTo(1);
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 500, 900, 1300, 9999})
    @DisplayName("천 단위로 나누어지지 않을 경우, 예외가 발생한다")
    void buy_ticket_not_divide_1000(int purchaseAmount) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Ticket ticket = new Ticket(purchaseAmount);
        });
        assertThat(exception.getMessage()).isEqualTo(PURCHASE_PRICE_DIVIDE_ERROR.getMessage());
    }

}
