package lotto.domain.entity;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.factory.WinningDetailFactory;
import lotto.domain.vo.WinningRank;

class WinningDetailTest {

    @Test
    @DisplayName("당첨 횟수를 업데이트한다")
    void updateScore() {
        WinningDetail winningDetail = WinningDetailFactory.create();

        winningDetail.updateScore(WinningRank.FIRST);
        winningDetail.updateScore(WinningRank.FIRST);
        winningDetail.updateScore(WinningRank.THIRD);

        String statistics = winningDetail.generateWinningStatistics();
        assertThat(statistics).contains("2");
        assertThat(statistics).contains("1");
    }

    @Test
    @DisplayName("당첨 통계를 생성한다")
    void generateWinningStatistics() {
        Map<WinningRank, Integer> detail = new EnumMap<>(WinningRank.class);
        detail.put(WinningRank.FIFTH, 1);
        detail.put(WinningRank.FOURTH, 1);
        detail.put(WinningRank.THIRD, 1);
        detail.put(WinningRank.SECOND, 1);
        detail.put(WinningRank.FIRST, 1);
        WinningDetail winningDetail = new WinningDetail(detail);

        String statistics = winningDetail.generateWinningStatistics();

        assertThat(statistics).contains("3개");
        assertThat(statistics).contains("4개");
        assertThat(statistics).contains("5개");
        assertThat(statistics).contains("6개");
    }

    @Test
    @DisplayName("총 상금을 계산한다")
    void calculateTotalPrizeMoney() {
        Map<WinningRank, Integer> detail = new EnumMap<>(WinningRank.class);
        detail.put(WinningRank.FIFTH, 2);
        detail.put(WinningRank.FIRST, 1);
        WinningDetail winningDetail = new WinningDetail(detail);

        long totalPrize = winningDetail.calculateTotalPrizeMoney();

        assertThat(totalPrize).isEqualTo(2_000_010_000L);
    }

    @Test
    @DisplayName("당첨 내역이 없으면 총 상금은 0이다")
    void calculateTotalPrizeMoneyWithNoWinning() {
        Map<WinningRank, Integer> detail = new EnumMap<>(WinningRank.class);
        WinningDetail winningDetail = new WinningDetail(detail);

        long totalPrize = winningDetail.calculateTotalPrizeMoney();

        assertThat(totalPrize).isZero();
    }

    @Test
    @DisplayName("같은 등수에 대해 당첨 횟수를 누적한다")
    void updateScoreAccumulate() {
        WinningDetail winningDetail = WinningDetailFactory.create();

        winningDetail.updateScore(WinningRank.FIFTH);
        winningDetail.updateScore(WinningRank.FIFTH);
        winningDetail.updateScore(WinningRank.FIFTH);

        String statistics = winningDetail.generateWinningStatistics();
        assertThat(statistics).contains("3");
    }
}
