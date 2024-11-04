package lotto.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @ParameterizedTest
    @MethodSource("provideRankingResult")
    void 당첨_순위_계산_테스트(int matchCount, boolean isMatch, Ranking expectRanking) {
        assertThat(Ranking.of(matchCount, isMatch)).isEqualTo(expectRanking);
    }

    static Stream<Arguments> provideRankingResult() {
        return Stream.of(
                Arguments.of(6, true, Ranking.FIRST),
                Arguments.of(5, true, Ranking.SECOND),
                Arguments.of(5, false, Ranking.THIRD),
                Arguments.of(4, false, Ranking.FOURTH),
                Arguments.of(3, false, Ranking.FIFTH),
                Arguments.of(2, false, Ranking.NONE)
        );
    }
}
