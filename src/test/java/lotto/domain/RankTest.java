package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("6개 일치 시 1등 반환")
    void success_rankFirst() {
        // given
        int matchCount = 6;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.fromMatchCount(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치 및 보너스 번호 일치 시 2등 반환")
    void success_rankSecondWithBonus() {
        // given
        int matchCount = 5;
        boolean hasBonus = true;

        // when
        Rank rank = Rank.fromMatchCount(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치 시 3등 반환")
    void success_rankThird() {
        // given
        int matchCount = 5;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.fromMatchCount(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 시 4등 반환")
    void success_rankFourth() {
        // given
        int matchCount = 4;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.fromMatchCount(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치 시 5등 반환")
    void success_rankFifth() {
        // given
        int matchCount = 3;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.fromMatchCount(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("일치하는 번호가 없을 시 NONE 반환")
    void success_rankNone() {
        // given
        int matchCount = 2;
        boolean hasBonus = false;

        // when
        Rank rank = Rank.fromMatchCount(matchCount, hasBonus);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
