package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("로또 당첨 순위를 확인한다.")
    @ParameterizedTest
    @MethodSource("checkRankData")
    void checkRankTest(List<Integer> ticketNumbers, int expectedRank) {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );

        Lotto lotto = new Lotto(ticketNumbers);
        int rank = winningLotto.checkRank(lotto);
        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> checkRankData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 3),
                Arguments.of(List.of(1, 2, 3, 4, 9, 10), 4),
                Arguments.of(List.of(1, 2, 3, 11, 12, 13), 5),
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), 0)
        );
    }
}
