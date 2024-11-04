package lotto.domain;

import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("getCount 호출시 가지고 있는 로또의 개수를 반환한다")
    @Test
    void getCount_호출시_가지고_있는_로또의_개수를_반환한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        LottoTickets lottoTickets = LottoTickets.of(List.of(lotto1, lotto2));

        // when
        int count = lottoTickets.getCount();

        // then
        assertThat(count).isEqualTo(2);
    }

    @DisplayName("getLottoNumbers 호출시 가지고 있는 로또들의 문자열을 반환한다")
    @Test
    void getLottoNumbers_호출시_가지고_있는_로또들의_문자열을_반환한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        LottoTickets lottoTickets = LottoTickets.of(List.of(lotto1, lotto2));

        // when
        List<String> lottoNumbers = lottoTickets.getLottoNumbers();

        // then
        assertThat(lottoNumbers).containsExactly(
                "[1, 2, 3, 4, 5, 6]",
                "[2, 3, 4, 5, 6, 7]");
    }

    @DisplayName("getWinningStatistics 호출시 가지고 있는 로또들의 당첨 통계를 반환한다")
    @Test
    void getWinningStatistics_호출시_가지고_있는_로또들의_당첨_통계를_반환한다() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        LottoTickets lottoTickets = LottoTickets.of(List.of(lotto1, lotto2));
        Set<Integer> winningNumbers = Set.of(2, 3, 4, 5, 6, 10);
        int bonusNumber = 7;

        // when
        WinningStatistics winningStatistics = lottoTickets.getWinningStatistics(winningNumbers, bonusNumber);

        // then
        assertThat(winningStatistics.getRankCount(SECOND)).isEqualTo(1);
        assertThat(winningStatistics.getRankCount(THIRD)).isEqualTo(1);
    }
}