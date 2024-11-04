package lotto;

import lotto.model.LottoRank;
import lotto.statistics.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("초기화 시, 당첨된 로또의 개수가 0이어야 한다.")
    @Test
    void init() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();

        //when & then
        for (LottoRank lottoRank : LottoRank.values()) {
            assertThat(lottoStatistics.getWinningCount(lottoRank))
                    .isEqualTo(0);
        }
    }

    @DisplayName("로또가 한번 당첨됐을 때, 당첨 개수는 1개이어야 한다.")
    @Test
    void incrementWinningCount_whenWinningOnce() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();
        LottoRank lottoRank = LottoRank.FIRST;

        //when
        lottoStatistics.incrementWinningCount(lottoRank);

        //then
        assertThat(lottoStatistics.getWinningCount(lottoRank))
                .isEqualTo(1);
    }

    @DisplayName("로또가 3번 당첨됐을 때, 당첨 개수는 3개이어야 한다.")
    @Test
    void incrementWinningCount_whenWinningThreeTimes() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();

        //when
        lottoStatistics.incrementWinningCount(LottoRank.FIRST);
        lottoStatistics.incrementWinningCount(LottoRank.FIRST);
        lottoStatistics.incrementWinningCount(LottoRank.SECOND);

        //then
        assertThat(lottoStatistics.getWinningCount(LottoRank.FIRST))
                .isEqualTo(2);
        assertThat(lottoStatistics.getWinningCount(LottoRank.SECOND))
                .isEqualTo(1);
    }

    @DisplayName("로또가 1번 당첨됐을 때, 당첨금을 계산한다.")
    @Test
    void calculatePrizeMoney_whenWinningOnce() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementWinningCount(LottoRank.FIRST);

        //when
        long prizeMoney = lottoStatistics.calculatePrizeMoney();

        //then
        assertThat(prizeMoney).isEqualTo(2000000000L);
    }

    @DisplayName("로또가 3번 당첨됐을 때, 당첨금을 계산한다.")
    @Test
    void calculatePrizeMoney_whenWinningThreeTimes() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementWinningCount(LottoRank.FIRST);
        lottoStatistics.incrementWinningCount(LottoRank.FIRST);
        lottoStatistics.incrementWinningCount(LottoRank.SECOND);

        //when
        long prizeMoney = lottoStatistics.calculatePrizeMoney();

        //then
        assertThat(prizeMoney).isEqualTo(4030000000L);
    }

    @DisplayName("로또가 1번 당첨됐을 때, 수익률을 계산한다.")
    @Test
    void calculateProfitMargin_whenWinningOnce() {
        //given
        int purchaseAmount = 8000;

        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementWinningCount(LottoRank.FIRST);
        long prizeMoney = lottoStatistics.calculatePrizeMoney();

        //when
        double profitMargin = lottoStatistics.calculateProfitMargin(purchaseAmount, prizeMoney);

        //then
        assertThat(profitMargin).isEqualTo(25000000);
    }

    @DisplayName("로또가 3번 당첨됐을 때, 수익률을 계산한다.")
    @Test
    void calculateProfitMargin_whenWinningThreeTimes() {
        //given
        int purchaseAmount = 8000;

        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementWinningCount(LottoRank.FIFTH);
        lottoStatistics.incrementWinningCount(LottoRank.FIFTH);
        lottoStatistics.incrementWinningCount(LottoRank.FOURTH);
        long prizeMoney = lottoStatistics.calculatePrizeMoney();

        //when
        double profitMargin = lottoStatistics.calculateProfitMargin(purchaseAmount, prizeMoney);

        //then
        assertThat(profitMargin).isEqualTo(750);
    }

}