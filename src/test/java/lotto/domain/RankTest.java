package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @DisplayName("매치된 숫자의 개수와 보너스 매치 여부에 따라 Rank 객체를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, SIX_MATCHES",
            "5, true, FIVE_MATCHES_WITH_BONUS",
            "5, false, FIVE_MATCHES",
            "4, false, FOUR_MATCHES",
            "3, false, THREE_MATCHES",
            "2, false, NO_MATCH",
            "1, false, NO_MATCH",
            "0, false, NO_MATCH"
    })
    void Rank_반환_테스트(int matchCount, boolean bonusMatch, Rank expectedRank) {
        Rank actualRank = Rank.valueOf(matchCount, bonusMatch);

        Assertions.assertThat(actualRank).isEqualTo(expectedRank);
    }

}
