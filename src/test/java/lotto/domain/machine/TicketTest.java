package lotto.domain.machine;

import static lotto.exception.message.TicketExceptionMessage.INVALID_MONEY_AMOUNT;
import static lotto.exception.message.TicketExceptionMessage.INVALID_MONEY_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketTest {

    @Test
    @DisplayName("천 원 단위의 금액이 아닐 경우, 예외가 발생한다.")
    void givenInvalidMoneyUnit_whenIssueTicket_thenThrowException() {
        // given
        int money = 1_234;

        // when & then
        assertThatThrownBy(() -> new Ticket(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MONEY_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999})
    @DisplayName("천원 미만의 금액일 경우, 예외가 발생한다.")
    void givenMoney_whenIssueTicket_thenTicketIssued(int money) {
        // given

        // when & then
        assertThatThrownBy(() -> new Ticket(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MONEY_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("티켓이 여러장 발급된 경우, 티켓을 사용해도 티켓이 남아있다.")
    void givenMoneyAndCreated_whenGetCount_thenGetTicketCounts() {
        // given
        Ticket ticket = new Ticket(2_000);

        // when
        int result = ticket.getCount();

        // then
        assertThat(result).isEqualTo(2);
    }

}