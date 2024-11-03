package lotto.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("6개 번호 일치 시 1등 (SIX_MATCH) 반환")
    @Test
    void 당첨_1등_테스트() {
        Rank rank = Rank.getRank(6, false);
        assertThat(rank).isEqualTo(Rank.SIX_MATCH);
    }

    @DisplayName("5개 번호 + 보너스 번호 일치 시 2등 (FIVE_MATCH_BONUS) 반환")
    @Test
    void 당첨_2등_테스트() {
        Rank rank = Rank.getRank(5, true);
        assertThat(rank).isEqualTo(Rank.FIVE_MATCH_BONUS);
    }

    @DisplayName("5개 번호 일치 시 3등 (FIVE_MATCH) 반환")
    @Test
    void 당첨_3등_테스트() {
        Rank rank = Rank.getRank(5, false);
        assertThat(rank).isEqualTo(Rank.FIVE_MATCH);
    }

    @DisplayName("4개 번호 일치 시 4등 (FOUR_MATCH) 반환")
    @Test
    void 당첨_4등_테스트() {
        Rank rank = Rank.getRank(4, false);
        assertThat(rank).isEqualTo(Rank.FOUR_MATCH);
    }

    @DisplayName("3개 번호 일치 시 5등 (THREE_MATCH) 반환")
    @Test
    void 당첨_5등_테스트() {
        Rank rank = Rank.getRank(3, false);
        assertThat(rank).isEqualTo(Rank.THREE_MATCH);
    }

    @DisplayName("일치하는 번호가 없거나 2개 이하일 경우 NO_MATCH 반환")
    @Test
    void 미당첨_테스트() {
        Rank rank1 = Rank.getRank(2, false);
        Rank rank2 = Rank.getRank(0, false);
        assertThat(rank1).isEqualTo(Rank.NO_MATCH);
        assertThat(rank2).isEqualTo(Rank.NO_MATCH);
    }
}
