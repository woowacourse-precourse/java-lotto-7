package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

public class PrizeRankTest {

    private static Stream<org.junit.jupiter.params.provider.Arguments> prizeRankParameters() {
        return Stream.of(
                of(6, false, PrizeRank.FIRST),
                of(5, true, PrizeRank.SECOND),
                of(5, false, PrizeRank.THIRD),
                of(4, false, PrizeRank.FOURTH),
                of(3, false, PrizeRank.FIFTH)
        );
    }

    @ParameterizedTest
    @DisplayName("일치하는 번호의 개수와 보너스 번호의 일치 여부로 등수를 계산한다")
    @MethodSource("prizeRankParameters")
    public void 등수_계산(int matchCount, boolean bonusMatch, PrizeRank expectedRank) {
        PrizeRank prizeRank = PrizeRank.of(matchCount, bonusMatch);
        assertThat(prizeRank).isEqualTo(expectedRank);
    }
}
