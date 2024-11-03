package lotto.utils;

import static lotto.common.ConstantsForTest.START_INCLUSIVE;
import static lotto.common.ConstantsForTest.VALID_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import lotto.common.NumberGenerator;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Rank;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCounterTest {

    @Test
    @DisplayName("각 로또 티켓의 순위를 알맞게 세어 반환한다.")
    void valid() {
        // given
        List<Integer> numbers = NumberGenerator.generateNumbersWithSizeAndRange(START_INCLUSIVE, VALID_SIZE);

        List<LottoTicket> lottoTickets = List.of(
                new LottoTicket(new Lotto(numbers))
        );

        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), 7);
        lottoTickets.forEach(lottoTicket -> lottoTicket.determineRank(winningLotto));

        // when
        Map<Rank, Integer> rankCounts = RankCounter.countRanks(lottoTickets);

        // then
        assertAll(
                () -> assertThat(rankCounts.get(Rank.FIRST_PLACE)).isEqualTo(1),
                () -> assertThat(rankCounts.get(Rank.SECOND_PLACE)).isEqualTo(0),
                () -> assertThat(rankCounts.get(Rank.THIRD_PLACE)).isEqualTo(0),
                () -> assertThat(rankCounts.get(Rank.FOURTH_PLACE)).isEqualTo(0),
                () -> assertThat(rankCounts.get(Rank.FIFTH_PLACE)).isEqualTo(0)
        );
    }
}
