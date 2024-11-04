package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Ticket;
import org.junit.jupiter.api.Test;

public class RankCounterTest {

    @Test
    void getRankCount_기능_테스트() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(List.of(1, 2, 3, 4, 5, 6)));
        tickets.add(new Ticket(List.of(3, 5, 11, 16, 32, 38)));
        tickets.add(new Ticket(List.of(7, 11, 16, 35, 36, 44)));
        tickets.add(new Ticket(List.of(1, 2, 3, 6, 22, 44)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(10, lotto.getNumbers());

        RankCounter counter = new RankCounter(tickets, lotto, bonus);

        assertThat(counter.getRankCount()).containsExactly(2L, 1L, 0L, 0L, 1L, 0L);
    }
}
