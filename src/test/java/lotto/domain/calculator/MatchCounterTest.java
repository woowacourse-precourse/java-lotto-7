package lotto.domain.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.core.Bonus;
import lotto.domain.core.Lotto;
import lotto.dto.result.MatchResult;
import lotto.dto.result.MatchResults;
import lotto.dto.result.SortedIssuedTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MatchCounterTest {

    private static Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static Bonus bonus = new Bonus(7, winningLotto);
    private static MatchCounter matchCounter = new MatchCounter(winningLotto, bonus);

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @ParameterizedTest
        @MethodSource("provideTicketsForMatchCountTest")
        @DisplayName("각 티켓의 매칭 결과가 올바르게 계산된다.")
        public void calculateMatchResults_성공(List<Integer> ticket, int expectedMatchCount, boolean expectedHasBonus) {
            SortedIssuedTickets tickets = new SortedIssuedTickets(List.of(ticket));

            MatchResults matchResults = matchCounter.calculateMatchResults(tickets);

            List<MatchResult> results = matchResults.results();
            assertThat(results).hasSize(1);
            assertThat(results.get(0)).isEqualTo(new MatchResult(expectedMatchCount, expectedHasBonus));
        }

        private static Stream<Arguments> provideTicketsForMatchCountTest() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 8, 9, 10), 3, false),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 10), 5, false),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5, true),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, false)
            );
        }
    }
}
