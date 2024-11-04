package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Ticket;
import org.junit.jupiter.api.Test;

public class TicketRandomGeneratorTest {

    @Test
    void getTickets_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    TicketRandomGenerator generator = new TicketRandomGenerator();
                    generator.setMoney(4000);
                    List<Ticket> tickets = generator.getTickets();
                    assertThat(tickets.stream().map(Ticket::getNumbers).toList()).containsExactly(
                            List.of(1, 2, 3, 4, 5, 6),
                            List.of(3, 5, 11, 16, 32, 38),
                            List.of(7, 11, 16, 35, 36, 44),
                            List.of(1, 2, 3, 6, 22, 44));
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 2, 3, 6, 22, 44)
        );
    }
}
