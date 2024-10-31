package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class WinningStatisticsTest {

    @ParameterizedTest
    @EnumSource(Rank.class)
    @DisplayName("맨 처음 통계 상태는 모두 0원이다.")
    void givenCreatedStatistics_whenGetCountByRank_thenAllZero(Rank rank) {
        // given
        WinningStatistics winningStatistics = new WinningStatistics();
        // when
        int result = winningStatistics.getCountByRank(rank);
        // then
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @EnumSource(Rank.class)
    @DisplayName("등수 별 당첨 수가 증가된다.")
    void givenCreatedStatistics_whenAddWinCountByRank_thenIncrementedCountByRank(Rank rank) {
        // given
        WinningStatistics winningStatistics = new WinningStatistics();

        // when
        winningStatistics.addWinCountByRank(rank);

        // then
        assertThat(winningStatistics.getCountByRank(rank)).isOne();
    }

}