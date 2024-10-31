package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("2등")
    void placedInTheSecondRank() {
        // given
        int matchedCount = 5;
        boolean bonusNumberMatched = true;

        // when
        Rank actual = Rank.getRankBy(matchedCount, bonusNumberMatched);

        // then
        Rank expected = Rank.SECOND;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("3등")
    void placedInTheThirdRank() {
        // given
        int matchedCount = 5;
        boolean bonusNumberMatched = false;

        // when
        Rank actual = Rank.getRankBy(matchedCount, bonusNumberMatched);

        // then
        Rank expected = Rank.THIRD;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("4등")
    void placedInTheFourthRank() {
        // given
        int matchedCount = 4;
        boolean bonusNumberMatched = false;

        // when
        Rank actual = Rank.getRankBy(matchedCount, bonusNumberMatched);

        // then
        Rank expected = Rank.FOURTH;
        assertThat(actual == expected).isTrue();
    }

}
