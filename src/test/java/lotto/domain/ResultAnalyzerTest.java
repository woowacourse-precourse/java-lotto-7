package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultAnalyzerTest {

    @DisplayName("3개 번호 일치할 때 5등 5000원")
    @Test
    void shouldReturn5thPlaceWhen3NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRank, Integer> rankCount = resultAnalyzer.getRankCounts(List.of(userTicket), winningNumbers, bonusNumber);

        assertThat(rankCount.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000);
    }

    @DisplayName("4개 번호 일치할 때 4등 50,000원")
    @Test
    void shouldReturn4thPlaceWhen4NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRank, Integer> rankCount = resultAnalyzer.getRankCounts(List.of(userTicket), winningNumbers, bonusNumber);

        assertThat(rankCount.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000);
    }

    @DisplayName("5개 번호 일치할 때 3등 1,500,000원")
    @Test
    void shouldReturn3rdPlaceWhen5NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRank, Integer> rankCount = resultAnalyzer.getRankCounts(List.of(userTicket), winningNumbers, bonusNumber);

        assertThat(rankCount.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000);
    }

    @DisplayName("5개 번호 + 보너스 번호 일치할 때 2등 30,000,000원")
    @Test
    void shouldReturn2ndPlaceWhen5NumbersPlusBonusMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRank, Integer> rankCount = resultAnalyzer.getRankCounts(List.of(userTicket), winningNumbers, bonusNumber);

        assertThat(rankCount.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("당첨번호 만 6개 번호 모두 일치할 때 1등 2,000,000,000원")
    @Test
    void shouldReturn1stPlaceWhenAllNumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRank, Integer> rankCount = resultAnalyzer.getRankCounts(List.of(userTicket), winningNumbers, bonusNumber);

        assertThat(rankCount.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("여러 티켓에 대해 등수 확인")
    @Test
    void shouldCalculateRanksForMultipleTickets() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 7, 8, 9, 10, 11)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoRank, Integer> rankCount = resultAnalyzer.getRankCounts(tickets, winningNumbers, bonusNumber);

        assertThat(rankCount.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(rankCount.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(rankCount.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(rankCount.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(rankCount.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(rankCount.get(LottoRank.NONE)).isEqualTo(3);
        assertThat(LottoRank.NONE.getPrize()).isEqualTo(0);
    }
}
