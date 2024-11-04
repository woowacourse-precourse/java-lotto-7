package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("6개 번호 일치 시 1등 반환")
    @Test
    void matchSixNumbers_returnsFirstRank() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2000000000);
    }

    @DisplayName("5개 번호 일치 + 보너스 번호 일치 시 2등 반환")
    @Test
    void matchFiveNumbersAndBonus_returnsSecondRank() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30000000);
    }

    @DisplayName("5개 번호 일치 시 3등 반환")
    @Test
    void matchFiveNumbers_returnsThirdRank() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1500000);
    }

    @DisplayName("4개 번호 일치 시 4등 반환")
    @Test
    void matchFourNumbers_returnsFourthRank() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getPrize()).isEqualTo(50000);
    }

    @DisplayName("3개 번호 일치 시 5등 반환")
    @Test
    void matchThreeNumbers_returnsFifthRank() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5000);
    }

    @DisplayName("일치하는 번호가 2개 이하일 때 당첨되지 않음 (NONE 반환)")
    @Test
    void lessThanThreeMatches_returnsNone() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getPrize()).isEqualTo(0);
    }
}
