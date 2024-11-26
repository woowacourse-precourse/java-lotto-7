package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST_PLACE",
            "5, true, SECOND_PLACE",
            "5, false, THIRD_PLACE",
            "4, true, FOURTH_PLACE",
            "4, false, FOURTH_PLACE",
            "3, true, FIFTH_PLACE",
            "3, false, FIFTH_PLACE",
            "2, true, MISS",
            "2, false, MISS",
            "1, true, MISS",
            "1, false, MISS",
    })
    @DisplayName("맞은 개수와 보너스 여부에 따라 순위를 반환한다.")
    void 맞은_개수와_보너스_여부에_따라_순위를_반환한다(int matchCount, boolean hasBonus, Rank expectedRank) {
        assertThat(Rank.of(matchCount, hasBonus)).isEqualTo(expectedRank);
    }
}