package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PrizeNumberMatcherTest {

    @Test
    void 당첨번호와_티켓번호_매칭_테스트() {
        // given
        PrizeNumber prizenumber = new PrizeNumber(List.of(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTicketBundle = List.of(
                new LottoTicket(List.of(6, 7, 8, 9, 10, 11)),
                new LottoTicket(List.of(1, 3, 5, 6, 9, 11)),
                new LottoTicket(List.of(2, 4, 6, 8, 10, 12)),
                new LottoTicket(List.of(2, 4, 6, 8, 10, 12))
        );
        Integer bonusNumber = 10;
        TicketPrizeMatcher ticketPrizeMatcher = new TicketPrizeMatcher(prizenumber, lottoTicketBundle, bonusNumber);

        // when
        MatchResult matchResult = ticketPrizeMatcher.matchAll();

        // then
        assertThat(matchResult.getProfitRatio()).isEqualTo(1400.0);
        assertThat(matchResult.getMatchedConditions()).hasSize(3);
        assertThat(matchResult.getMatchedConditions().get(0).getPrizedAmount()).isEqualTo(50000);
        assertThat(matchResult.getMatchedConditions().get(0).getNumberCount()).isEqualTo(4);
        assertThat(matchResult.getMatchedConditions().get(1).getPrizedAmount()).isEqualTo(5000);
        assertThat(matchResult.getMatchedConditions().get(1).getNumberCount()).isEqualTo(3);
        assertThat(matchResult.getMatchedConditions().get(2).getPrizedAmount()).isEqualTo(5000);
        assertThat(matchResult.getMatchedConditions().get(2).getNumberCount()).isEqualTo(3);
    }
}
