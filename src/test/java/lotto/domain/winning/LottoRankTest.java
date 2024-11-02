package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 7})
    @DisplayName("당첨금 기준과 일치하지 않으면 꼴등이다.")
    void test(int matchCount) {
        // given
        boolean bonus = false;

        // when
        LottoRank result = LottoRank.of(matchCount, bonus);

        // then
        assertThat(result).isEqualTo(LottoRank.NONE);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("6개를 맞춘 경우, 보너스 여부 없이 1등이다.")
    void givenSixMatchCount_whenCreateRank_thenFirstRank(boolean bonus) {
        // given
        int matchCount = 6;

        // when
        LottoRank result = LottoRank.of(matchCount, bonus);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_FIRST);
    }

    @Test
    @DisplayName("5개를 맞춘 경우, 보너스를 맞추면 2등이다.")
    void givenFiveMatchCountAndBonusNumberMatch_whenCreateRank_thenSecondRank() {
        // given
        int matchCount = 5;
        boolean bonusNumberMatch = true;

        // when
        LottoRank result = LottoRank.of(matchCount, bonusNumberMatch);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_SECOND);
    }

    @Test
    @DisplayName("5개를 맞춘 경우, 보너스를 맞추지 못했다면 3등이다.")
    void givenFiveMatchCountAndNoBonusNumberMatch_whenCreateRank_thenThirdRank() {
        // given
        int matchCount = 5;
        boolean bonusNumberMatch = false;

        // when
        LottoRank result = LottoRank.of(matchCount, bonusNumberMatch);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_THIRD);
    }


    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("4개를 맞춘 경우, 보너스 여부 없이 4등이다.")
    void givenFourMatchCount_whenCreateRank_thenFourthRank(boolean bonus) {
        // given
        int matchCount = 4;

        // when
        LottoRank result = LottoRank.of(matchCount, bonus);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_FOURTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("3개를 맞춘 경우, 보너스 여부 없이 5등이다.")
    void givenThreeMatchCount_whenCreateRank_thenFifthRank(boolean bonus) {
        // given
        int matchCount = 3;

        // when
        LottoRank result = LottoRank.of(matchCount, bonus);

        // then
        assertThat(result).isEqualTo(LottoRank.PRIZE_FIFTH);
    }

}