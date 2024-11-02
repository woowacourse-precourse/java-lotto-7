package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @DisplayName("매치된 숫자의 개수와 보너스 매치 여부에 따라 Rank 객체를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, false, MISS",
            "0, false, MISS"
    })
    void Rank_반환_테스트(int matchCount, boolean bonusMatch, Rank expectedRank) {
        Rank actualRank = Rank.valueOf(matchCount, bonusMatch);

        assertThat(actualRank).isEqualTo(expectedRank);
    }

}
