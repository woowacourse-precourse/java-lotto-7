package lotto.service;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @DisplayName("모든 구매한 로또와 당첨로또를 비교한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTicketsAndWinningNumberAndBonusNumber")
    void 모든_구매한_로또와_당첨로또를_비교한다(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber, List<Rank> expectedRanks) {
        LottoService lottoService = new LottoService();
        List<Rank> ranks = lottoService.calculateLotto(lottoTickets, winningNumber, bonusNumber);

        assertThat(ranks).containsExactlyElementsOf(expectedRanks);
    }

    static Stream<Arguments> provideLottoTicketsAndWinningNumberAndBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 7),
                                List.of(1, 2, 3, 4, 5, 8),
                                List.of(1, 2, 3, 4, 8, 9),
                                List.of(1, 2, 3, 8, 9, 10),
                                List.of(1, 2, 8, 9, 10, 11),
                                List.of(1, 2, 3, 4, 5, 6)),
                        List.of(1, 2, 3, 4, 5, 6), 7,
                        List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.NONE, Rank.FIRST))
        );
    }
}