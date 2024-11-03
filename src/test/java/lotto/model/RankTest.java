package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    @ParameterizedTest
    @MethodSource("checkRankArgs")
    void checkRank(Rank rank, int matchCount, boolean isOk) {
        assertThat(rank.checkRank(matchCount, isOk))
                .isEqualTo(true);

    }

    static Stream<Arguments> checkRankArgs() {
        return Stream.of(
                Arguments.arguments(Rank.FIFTH, 3, false, 1),
                Arguments.arguments(Rank.FOURTH, 4, false, 1),
                Arguments.arguments(Rank.THIRD, 5, false, 1),
                Arguments.arguments(Rank.SECOND, 5, true, 1),
                Arguments.arguments(Rank.FIRST, 6, false, 1)
        );
    }
}