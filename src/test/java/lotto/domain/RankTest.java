package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("일치하는 번호 개수와 (5개인 경우)보너스 번호 적중 여부에 따라 정확한 등수와 상금이 나온다.")
    @ParameterizedTest
    @MethodSource("provideRanks")
    void rankingTest(
        Rank expectedRank,
        int expectedPrize,
        int requiredMatchCount,
        boolean isBonusNumberMatched) {
        Rank computedRank = Rank.of(requiredMatchCount, isBonusNumberMatched);

        assertThat(computedRank).isEqualTo(expectedRank);
        assertThat(computedRank.getPrize()).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> provideRanks() {
        return Stream.of(
            Arguments.of(Rank.FIRST, 2_000_000_000, 6, true),
            Arguments.of(Rank.FIRST, 2_000_000_000, 6, false),

            Arguments.of(Rank.SECOND, 30_000_000, 5, true),

            Arguments.of(Rank.THIRD, 1_500_000, 5, false),

            Arguments.of(Rank.FOURTH, 50_000, 4, true),
            Arguments.of(Rank.FOURTH, 50_000, 4, false),

            Arguments.of(Rank.FIFTH, 5_000, 3, true),
            Arguments.of(Rank.FIFTH, 5_000, 3, false),

            Arguments.of(Rank.DRAW, 0, 2, true),
            Arguments.of(Rank.DRAW, 0, 2, false),
            Arguments.of(Rank.DRAW, 0, 0, true),
            Arguments.of(Rank.DRAW, 0, 0, false)
        );
    }
}