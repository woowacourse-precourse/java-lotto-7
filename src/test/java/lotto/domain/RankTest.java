package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @DisplayName("6개 번호 일치 + 보너스 번호 일치 시 1등")
    @Test
    void getRank_first_hasBonus() {
        // given
        int matchCount = 6;
        boolean hasBonus = true;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }

    @DisplayName("6개 번호 일치 시 1등")
    @Test
    void getRank_first() {
        // given
        int matchCount = 6;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }

    @DisplayName("5개 번호 일치 + 보너스 번호 일치 시 2등")
    @Test
    void getRank_second() {
        // given
        int matchCount = 5;
        boolean hasBonus = true;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }

    @DisplayName("5개 번호 일치 시 3등")
    @Test
    void getRank_third() {
        // given
        int matchCount = 5;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.THIRD);
    }

    @DisplayName("4개 번호 일치 시 4등")
    @Test
    void getRank_fourth() {
        // given
        int matchCount = 4;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호 일치 시 5등")
    @Test
    void getRank_fifth() {
        // given
        int matchCount = 3;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIFTH);
    }

    @DisplayName("번호 2개 이하 일치 시 당첨 등수 없음")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void getRank_none(int matchCount) {
        // given
        boolean hasBonus = false;

        // when
        Rank rank = Rank.getRank(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.NONE);
    }

}