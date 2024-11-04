package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("6개 일치, 보너스 번호 불일치 시 1등")
    void valueOf_sixMatch_noBonus_shouldReturnFirst() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치, 보너스 번호 일치 시 2등")
    void valueOf_fiveMatch_bonusMatch_shouldReturnSecond() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치, 보너스 번호 불일치 시 3등")
    void valueOf_fiveMatch_noBonus_shouldReturnThird() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 시 4등")
    void valueOf_fourMatch_shouldReturnFourth() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치 시 5등")
    void valueOf_threeMatch_shouldReturnFifth() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치 시 등수 없음")
    void valueOf_lessThanThreeMatch_shouldReturnNone() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
