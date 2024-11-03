package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("일치하는 번호 개수와 보너스 번호 여부에 따라 올바른 Rank 를 반환한다")
    @ParameterizedTest
    @MethodSource("findRankData")
    void findRank(int matchCount, boolean hasBonusNumber, Rank expectedRank) {

        Rank rank = Rank.findRank(matchCount, hasBonusNumber);

        assertThat(rank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> findRankData() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.NONE)
        );
    }
}
