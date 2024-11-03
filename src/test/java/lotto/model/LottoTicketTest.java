package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 발행")
    void of() {
        assertSimpleTest(() -> {
                    LottoTicket ticket = LottoTicket.of(3);
                    assertThat(ticket.getTicket().size()).isEqualTo(3);
                }
        );
    }

    @Test
    @DisplayName("로또 티켓 등수 목록 반환")
    void getRanks() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoTicket lottoTicket = LottoTicket.of(6);
                    WinningTicket winningTicket = WinningTicket.of("1,2,3,4,5,6", "7");
                    List<Rank> ranks = lottoTicket.getRanks(winningTicket);
                    assertThat(ranks.get(0)).isEqualTo(null);
                    assertThat(ranks.get(1)).isEqualTo(Rank.FIFTH);
                    assertThat(ranks.get(2)).isEqualTo(Rank.FOURTH);
                    assertThat(ranks.get(3)).isEqualTo(Rank.THIRD);
                    assertThat(ranks.get(4)).isEqualTo(Rank.SECOND);
                    assertThat(ranks.get(5)).isEqualTo(Rank.FIRST);
                },
                List.of(11, 12, 13, 14, 15, 16),
                List.of(1, 2, 3, 14, 15, 16),
                List.of(1, 2, 3, 4, 15, 16),
                List.of(1, 2, 3, 4, 5, 16),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6));
    }
}
