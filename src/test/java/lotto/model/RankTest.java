package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("getMatchCount() 메서드는 일치하는 번호 개수를 반환한다.")
    void getMatchCount() {
        // GIVEN
        Rank rank = Rank.FIRST;

        // WHEN
        int matchCount = rank.getMatchCount();

        // THEN
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("getPrize() 메서드는 해당 등수의 상금을 반환한다.")
    void getPrize() {
        // GIVEN
        Rank rank = Rank.SECOND;

        // WHEN
        int prize = rank.getPrize();

        // THEN
        assertThat(prize).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("valueOf() 메서드는 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 Rank를 반환한다.")
    void valueOf() {
        // WHEN
        Rank rank1 = Rank.valueOf(6, false);
        Rank rank2 = Rank.valueOf(5, true);
        Rank rank3 = Rank.valueOf(3, false);
        Rank rank4 = Rank.valueOf(0, false);

        // THEN
        assertThat(rank1).isEqualTo(Rank.FIRST);
        assertThat(rank2).isEqualTo(Rank.SECOND);
        assertThat(rank3).isEqualTo(Rank.FIFTH);
        assertThat(rank4).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("values() 메서드는 모든 Rank 값을 반환한다.")
    void values() {
        // WHEN
        Rank[] ranks = Rank.values();

        // THEN
        assertThat(ranks).hasSize(6); // Rank의 총 개수
    }

    @Test
    @DisplayName("testValueOf() 메서드는 잘못된 값에 대해 NONE을 반환한다.")
    void testValueOf() {
        // WHEN
        Rank rank = Rank.valueOf(7, false); // 잘못된 조건

        // THEN
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
