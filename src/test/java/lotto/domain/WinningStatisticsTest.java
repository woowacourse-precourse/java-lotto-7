package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("당첨 통계에 당첨 결과가 저장된다")
    @Test
    void 당첨_통계에_당첨_결과가_저장된다() {
        // given
        WinningStatistics winningStatistics = WinningStatistics.init();

        // when
        winningStatistics.saveWinningResult(Rank.SECOND);

        // then
        assertThat(winningStatistics.getRankCount(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("구매금액을 입력받아 총 수익률을 반환한다")
    @Test
    void 구매금액을_입력받아_총_수익률을_반환한다() {
        // given
        WinningStatistics winningStatistics = WinningStatistics.init();
        winningStatistics.saveWinningResult(Rank.FOURTH);

        // when
        double rateOfReturn = winningStatistics.calculateRateOfReturn(10000);

        // then
        assertThat(rateOfReturn).isEqualTo(500, withPrecision(2d));
    }


}