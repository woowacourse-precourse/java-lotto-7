package lotto.domain;

import java.util.List;
import lotto.global.common.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LotteriesTest {

    private final static int TICKETS_SIZE = 10;

    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final int bonus = 7;

    @Test
    void 각_티켓들의_결과_확인() {
        //given
        Lotteries tickets = Lotteries.of(TICKETS_SIZE);

        //when
        List<Rank> ticketsResults = tickets.getTicketsResult(winningLotto, bonus);
        System.out.println(ticketsResults);
        System.out.println(tickets);

        //then
        Assertions.assertThat(ticketsResults).containsAnyOf(Rank.values());
    }
}