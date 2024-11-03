package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("로또의 당첨 결과 개수를 확인한다.")
    @ParameterizedTest
    @MethodSource("lottoWinningResultTestData")
    void lottoWinningResultTest(List<Lotto> lottoList, Map<Rank, Integer> expectedResults) {
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        WinningLotto winningLotto = new WinningLotto(
                List.of(1, 2, 3, 4, 5, 6), 7
        );

        Map<Rank, Integer> result = winningLotto.lottoWinningResult(lottoTicket);

        assertThat(result).isEqualTo(expectedResults);
    }

    static Stream<Arguments> lottoWinningResultTestData() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                                new Lotto(List.of(1, 2, 3, 11, 12, 13))
                        ),
                        Map.of(
                                Rank.FIRST, 1,
                                Rank.SECOND, 1,
                                Rank.THIRD, 1,
                                Rank.FOURTH, 1,
                                Rank.FIFTH, 1
                        )
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(8, 9, 10, 11, 12, 13))
                        ),
                        Map.of(
                                Rank.FIRST, 2,
                                Rank.THIRD, 1,
                                Rank.NONE, 1
                        )
                )
        );
    }
}
