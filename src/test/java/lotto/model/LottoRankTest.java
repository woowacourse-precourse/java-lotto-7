package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("6개 일치 시 1등을 반환")
    void matchSixReturnsFirst() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("5개 + 보너스 일치 시 2등을 반환")
    void matchFiveAndBonusReturnsSecond() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개 일치 시 3등을 반환")
    void matchFiveReturnsThird() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 시 4등을 반환")
    void matchFourReturnsFourth() {
        LottoRank rank = LottoRank.valueOf(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치 시 5등을 반환")
    void matchThreeReturnsFifth() {
        LottoRank rank = LottoRank.valueOf(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치 시 꽝을 반환")
    void matchTwoOrLessReturnsMiss() {
        LottoRank rank = LottoRank.valueOf(2, false);
        assertThat(rank).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("당첨금 확인")
    void checkPrizeAmount() {
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000);
    }
}