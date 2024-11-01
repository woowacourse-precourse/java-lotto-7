package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
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

    @Test
    @DisplayName("등수 별 당첨 수가 증가됐을 경우, 모두 합한 금액이 반환된다.")
    void givenAddWinCountByRank_whenGetTotalPrize_thenReturnExpected() {
        // given
        WinningStatistics winningStatistics = new WinningStatistics();
        int sumOfAllRankPrize = 0;
        for (Rank rank : Rank.values()) {
            winningStatistics.addWinCountByRank(rank);
            sumOfAllRankPrize += rank.getPrizeMoney();
        }

        // when
        BigDecimal result = winningStatistics.getTotalPrize();

        // then
        assertThat(result).isEqualTo(BigDecimal.valueOf(sumOfAllRankPrize));
    }

    @Test
    @DisplayName("당첨 금액이 약 21억이 넘을 경우, Int Max 값을 초과한 결과를 반환한다.")
    void givenAddWinTwoCountOfFirstRank_whenGetTotalPrize_thenReturnExpected(){
        // given
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addWinCountByRank(Rank.FIRST);
        winningStatistics.addWinCountByRank(Rank.FIRST);

        // when
        BigDecimal result = winningStatistics.getTotalPrize();

        // then
        assertThat(result).isGreaterThan(BigDecimal.valueOf(Integer.MAX_VALUE));
    }

}