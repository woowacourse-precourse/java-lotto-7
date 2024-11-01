package lotto.domain.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumbersTestCase;
import lotto.global.common.Rank;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class TicketTest {

    private final Ticket winningTicket = Ticket.of(List.of(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest
    @EnumSource(value = LottoNumbersTestCase.class)
    void 당첨_여부_확인(LottoNumbersTestCase testCase) {
        //given
        Ticket ticket = Ticket.of(testCase.numbers, testCase.bonus);

        //when
        Rank check = ticket.check(winningTicket);

        //then
        assertThat(check).isInstanceOf(Rank.class);
        assertThat(check).isEqualTo(testCase.rank);
    }
}