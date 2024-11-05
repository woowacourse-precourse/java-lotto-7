package lotto.domain;

import static lotto.domain.Rank.findRank;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"6,FIRST,false", "5,SECOND,true", "5,THIRD,false", "4,FOURTH,false", "3,FIFTH,false"})
    void 등수_계산_테스트(int score, Rank expectedRank, boolean isBonusNumberEqual) {

        Rank actualRank = findRank(score, isBonusNumberEqual);
        assertThat(actualRank).isEqualTo(expectedRank);
    }
}
