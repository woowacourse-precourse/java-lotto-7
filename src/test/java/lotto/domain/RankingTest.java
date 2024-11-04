package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import lotto.model.Ranking;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankingTest {

    static Stream<Arguments> matchingCountParameters() {
        return Stream.of(
                Arguments.of(Ranking.FIRST, 6, false),
                Arguments.of(Ranking.SECOND, 5, true),
                Arguments.of(Ranking.THIRD, 5, false),
                Arguments.of(Ranking.FOURTH, 4, false),
                Arguments.of(Ranking.FIFTH, 3, false),
                Arguments.of(Ranking.FOURTH, 4, true),
                Arguments.of(Ranking.FIFTH, 3, true),
                Arguments.of(Ranking.NONE, 2, false),
                Arguments.of(Ranking.NONE, 1, false),
                Arguments.of(Ranking.NONE, 0, false),
                Arguments.of(Ranking.NONE, 2, true),
                Arguments.of(Ranking.NONE, 1, true),
                Arguments.of(Ranking.NONE, 0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("matchingCountParameters")
    void 일치_개수로_등수_판별(Ranking expected, int matchCount, boolean isBonusMatch) {
        Ranking actual = Ranking.findByMatchAndBonus(matchCount, isBonusMatch);
        assertEquals(expected, actual);
    }
}
