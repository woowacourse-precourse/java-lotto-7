package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.dto.WinningResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    @ParameterizedTest
    @MethodSource("provideWinningResult")
    void 당첨_결과에_해당하는_등수를_반환할_수_있다(WinningResult input, Rank rank) {
        Rank result = Rank.getRank(input);
        assertThat(result).isEqualTo(rank);
    }

    private static Stream<Arguments> provideWinningResult() {
        return Stream.of(
                Arguments.of(new WinningResult(6, 0), Rank.FIRST),
                Arguments.of(new WinningResult(5, 1), Rank.SECOND),
                Arguments.of(new WinningResult(5, 0), Rank.THIRD),
                Arguments.of(new WinningResult(4, 1), Rank.FOURTH),
                Arguments.of(new WinningResult(4, 0), Rank.FOURTH),
                Arguments.of(new WinningResult(3, 1), Rank.FIFTH),
                Arguments.of(new WinningResult(1, 1), Rank.NONE)
        );
    }
}