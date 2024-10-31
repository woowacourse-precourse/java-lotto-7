package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.rank.RankCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankConditionTest {

    @Test
    @DisplayName("2등")
    void placedInTheSecondRank() {
        // given
        int matchedCount = 5;
        boolean bonusNumberMatched = true;

        // when
        RankCondition actual = RankCondition.getRankBy(matchedCount, bonusNumberMatched);

        // then
        RankCondition expected = RankCondition.SECOND;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("3등")
    void placedInTheThirdRank() {
        // given
        int matchedCount = 5;
        boolean bonusNumberMatched = false;

        // when
        RankCondition actual = RankCondition.getRankBy(matchedCount, bonusNumberMatched);

        // then
        RankCondition expected = RankCondition.THIRD;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("4등")
    void placedInTheFourthRank() {
        // given
        int matchedCount = 4;
        boolean bonusNumberMatched = false;

        // when
        RankCondition actual = RankCondition.getRankBy(matchedCount, bonusNumberMatched);

        // then
        RankCondition expected = RankCondition.FOURTH;
        assertThat(actual == expected).isTrue();
    }

}
