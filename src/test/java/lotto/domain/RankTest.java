package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import lotto.domain.winning.Rank;
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

    @DisplayName("Rank에 따라 올바른 당첨 통계 양식을 반환한다.")
    @ParameterizedTest
    @MethodSource("formatWinningStatisticsData")
    void formatWinningStatisticsTest(Rank rank, int count, String expectedOutput) {
        String result = rank.formatWinningStatistics(count);
        assertThat(result).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> formatWinningStatisticsData() {
        return Stream.of(
                Arguments.of(Rank.FIRST, 1, "6개 일치 (2,000,000,000원) - 1개"),
                Arguments.of(Rank.SECOND, 2, "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개"),
                Arguments.of(Rank.THIRD, 0, "5개 일치 (1,500,000원) - 0개"),
                Arguments.of(Rank.FOURTH, 5, "4개 일치 (50,000원) - 5개"),
                Arguments.of(Rank.FIFTH, 10, "3개 일치 (5,000원) - 10개"),
                Arguments.of(Rank.NONE, 0, "0개 일치 (0원) - 0개")
        );
    }
}
