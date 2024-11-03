package lotto.domain.constant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @ParameterizedTest
    @MethodSource("provideRankingTestCases")
    void test(int matchingCount, boolean hasBonusNumber, Ranking expectedRanking) {
        //given
        //when
        Ranking ranking = Ranking.getRanking(matchingCount, hasBonusNumber);
        //then
        assertThat(ranking).isEqualTo(expectedRanking);
    }

    private static Stream<Arguments> provideRankingTestCases() {
        return Stream.of(
                Arguments.of(6, true, Ranking.FIRST),   // 1등
                Arguments.of(6, false, Ranking.FIRST),   // 1등

                Arguments.of(5, true, Ranking.SECOND),   // 2등
                Arguments.of(5, false, Ranking.THIRD),   // 3등

                Arguments.of(4, true, Ranking.FOURTH),  // 4등
                Arguments.of(4, false, Ranking.FOURTH),  // 4등

                Arguments.of(3, true, Ranking.FIFTH),    // 5등
                Arguments.of(3, false, Ranking.FIFTH),    // 5등

                Arguments.of(0, false, Ranking.NONE),      // 일치 없음
                Arguments.of(0, true, Ranking.NONE)      // 일치 없음
        );
    }
}