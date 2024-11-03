package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled
public class TicketGeneratorTest {

    @Test
    @DisplayName("구입 금액에 따른 로또 티켓 개수 생성")
    void shouldGenerateExpectedNumberOfTickets() {
        int ticketCount = 5; // 티켓 개수
        TicketGenerator generator = new TicketGenerator();

        List<Lotto> tickets = generator.generateTickets(ticketCount);

        assertThat(tickets).hasSize(ticketCount);
    }

    @Test
    @DisplayName("각 로또 티켓이 6개의 숫자를 포함")
    void eachTicketShouldContainSixNumber() {
        int ticketCount = 3; // 원하는 티켓 수
        TicketGenerator generator = new TicketGenerator();

        List<Lotto> tickets = generator.generateTickets(ticketCount);

        tickets.forEach(ticket -> assertThat(ticket.getNumbers()).hasSize(6));
    }

    @Test
    @DisplayName("1~45 범위의 숫자를 생성")
    void eachNumberShouldBeWithinRange() {
        int ticketCount = 3; // 원하는 티켓 수
        TicketGenerator generator = new TicketGenerator();

        List<Lotto> tickets = generator.generateTickets(ticketCount);

        tickets.forEach(ticket ->
                assertThat(ticket.getNumbers()).allMatch(number -> number >= 1 && number <= 45)
        );
    }

    @Test
    @DisplayName("각 티켓의 숫자들은 중복되지 않은 숫자를 포함")
    void eachTicketShouldHaveUniqueNumbers() {
        int ticketCount = 3; // 원하는 티켓 수
        TicketGenerator generator = new TicketGenerator();

        List<Lotto> tickets = generator.generateTickets(ticketCount);

        tickets.forEach(ticket -> assertThat(ticket.getNumbers()).doesNotHaveDuplicates());
    }

    @Test
    @DisplayName("각 티켓의 숫자들은 오름차순의 정렬 순서를 가져야함")
    void eachTicketShouldHaveNumbersIsAscendingOrder() {
        int ticketCount = 3; // 원하는 티켓 수
        TicketGenerator generator = new TicketGenerator();

        List<Lotto> tickets = generator.generateTickets(ticketCount);

        tickets.forEach(ticket -> {
            List<Integer> numbers = ticket.getNumbers();
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            assertThat(numbers).isEqualTo(sortedNumbers);
        });
    }
}
