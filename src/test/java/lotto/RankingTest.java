package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import lotto.util.Ranking;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankingTest {
    @ParameterizedTest
    @MethodSource("providerRankingData")
    void 당첨_순위_계산_성공(int matchingCount, boolean hasBonusNumber, Ranking expectedRank) {
        Ranking actualRank = Ranking.getRanking(matchingCount, hasBonusNumber);
        assertThat(actualRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> providerRankingData() {
        return Stream.of(
                Arguments.of(6, true, Ranking.FIRST),
                Arguments.of(5, true, Ranking.SECOND),
                Arguments.of(5, false, Ranking.THIRD),
                Arguments.of(4, false, Ranking.FOURTH),
                Arguments.of(3, false, Ranking.FIFTH),
                Arguments.of(0, false, Ranking.NONE)
        );
    }
}
