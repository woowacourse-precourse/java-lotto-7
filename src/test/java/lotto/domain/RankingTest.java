package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, true, MISS",
            "0, false, MISS"
    })
    void 조건에_따라_Ranking을_찾는다(int matchCount, boolean isMatchBonus, Ranking expectedRanking) {
        assertThat(Ranking.findBy(matchCount, isMatchBonus)).isEqualTo(expectedRanking);
    }
}