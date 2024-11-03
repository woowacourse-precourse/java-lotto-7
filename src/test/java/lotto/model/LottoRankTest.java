package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("6개 번호 일치 시 1등 반환")
    void whenSixMatches_thenReturnFirstRank() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호 일치 시 2등 반환")
    void whenFiveMatchesAndBonusMatches_thenReturnSecondRank() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치 시 3등 반환")
    void whenFiveMatchesWithoutBonus_thenReturnThirdRank() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4개 번호 일치 시 4등 반환")
    void whenFourMatches_thenReturnFourthRank() {
        LottoRank rank = LottoRank.valueOf(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("3개 번호 일치 시 5등 반환")
    void whenThreeMatches_thenReturnFifthRank() {
        LottoRank rank = LottoRank.valueOf(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하의 번호 일치 시 등수 없음 반환")
    void whenLessThanThreeMatches_thenReturnNoneRank() {
        LottoRank rank = LottoRank.valueOf(2, false);
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}