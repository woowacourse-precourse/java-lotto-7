package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @DisplayName("6개 번호가 모두 일치하면 1등을 반환한다.")
    @Test
    void allNumbersMatch_returnsFirstRank() {
        Rank rank = Rank.getRank(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void fiveNumbersMatchWithBonus_returnsSecondRank() {
        Rank rank = Rank.getRank(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호가 일치하지만 보너스 번호가 일치하지 않으면 3등을 반환한다.")
    @Test
    void fiveNumbersMatchWithoutBonus_returnsThirdRank() {
        Rank rank = Rank.getRank(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다.")
    @Test
    void fourNumbersMatch_returnsFourthRank() {
        Rank rank = Rank.getRank(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등을 반환한다.")
    @Test
    void threeNumbersMatch_returnsFifthRank() {
        Rank rank = Rank.getRank(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("일치하는 번호가 없으면 NONE을 반환한다.")
    @Test
    void noMatches_returnsNoneRank() {
        Rank rank = Rank.getRank(0, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("일치하는 번호가 2개이고 보너스 번호가 일치하지 않으면 NONE을 반환한다.")
    @Test
    void twoNumbersMatchWithoutBonus_returnsNoneRank() {
        Rank rank = Rank.getRank(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
