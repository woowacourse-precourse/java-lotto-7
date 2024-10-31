package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("조건에 따라 적절한 순위 객체가 반환된다.")
    void returnRightRoundAccordingToConditions() {
        // given
        int matchingCount = 5;
        boolean bonusNumberMatched = true;

        // when
        Rank rank = Rank.findRank(matchingCount, bonusNumberMatched);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }
}
