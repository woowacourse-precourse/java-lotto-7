package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultAnalyzerTest {

    @DisplayName("3개 번호 일치할 때 5등 5000원")
    @Test
    void shouldReturn5thPlaceWhen3NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int rank = resultAnalyzer.calculateRank(winningNumbers, bonusNumber, userTicket);

        assertThat(rank).isEqualTo(5);
    }

    @DisplayName("4개 번호 일치할 때 4등 50,000원")
    @Test
    void shouldReturn4thPlaceWhen3NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int rank = resultAnalyzer.calculateRank(winningNumbers, bonusNumber, userTicket);

        assertThat(rank).isEqualTo(4);
    }

    @DisplayName("5개 번호 일치할 때 3등 1,500,000원")
    @Test
    void shouldReturn3thPlaceWhen3NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int rank = resultAnalyzer.calculateRank(winningNumbers, bonusNumber, userTicket);

        assertThat(rank).isEqualTo(3);
    }

    @DisplayName("5개 번호 + 보너스 번호 일치할 때 2등 30,000,000원")
    @Test
    void shouldReturn2thPlaceWhen3NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int rank = resultAnalyzer.calculateRank(winningNumbers, bonusNumber, userTicket);

        assertThat(rank).isEqualTo(2);
    }

    @DisplayName("당첨번호 만 6개 번호 모두 일치할 때 1등 2,000,000,000원")
    @Test
    void shouldReturn1thPlaceWhen3NumbersMatch() {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Lotto userTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int rank = resultAnalyzer.calculateRank(winningNumbers, bonusNumber, userTicket);

        assertThat(rank).isEqualTo(1);
    }

    static Stream<Arguments> provideMultipleTicketsTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7,
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                                new Lotto(List.of(1, 7, 8, 10, 11, 12)),
                                new Lotto(List.of(1, 2, 7, 10, 11, 12))
                        ),
                        List.of(1, 2, 3, 4, 5, 0, 0, 0) // 기대하는 등수 리스트
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideMultipleTicketsTestCases")
    @DisplayName("여러 티켓에 대해 등수 확인")
    void shouldCalculateRanksForMultipleTickets(List<Integer> winningNumbers, int bonusNumber, List<Lotto> tickets, List<Integer> expectedRanks) {
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();

        List<Integer> ranks = resultAnalyzer.calculateRanks(winningNumbers, bonusNumber, tickets);

        assertThat(ranks).isEqualTo(expectedRanks);
    }

}
