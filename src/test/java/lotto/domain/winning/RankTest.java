package lotto.domain.winning;

import static lotto.resources.Constants.FAIL_MATCH_BONUS;
import static lotto.resources.Constants.MATCH_BONUS;
import static lotto.resources.Constants.MATCH_FIVE;
import static lotto.resources.Constants.MATCH_FOUR;
import static lotto.resources.Constants.MATCH_SIX;
import static lotto.resources.Constants.MATCH_THREE;
import static lotto.resources.Constants.ZERO;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    private static Stream<Arguments> provideRankTestCases() {
        return Stream.of(
                Arguments.of(Rank.of(MATCH_SIX, FAIL_MATCH_BONUS), 200000000),
                Arguments.of(Rank.of(MATCH_FIVE, MATCH_BONUS), 30000000),
                Arguments.of(Rank.of(MATCH_FIVE, FAIL_MATCH_BONUS), 1500000),
                Arguments.of(Rank.of(MATCH_FOUR, FAIL_MATCH_BONUS), 50000),
                Arguments.of(Rank.of(MATCH_THREE, FAIL_MATCH_BONUS), 5000),
                Arguments.of(Rank.of(ZERO, FAIL_MATCH_BONUS), 0)
        );
    }

    @DisplayName("Rank에 따라 적절한 상금을 반환한다.")
    @MethodSource("provideRankTestCases")
    @ParameterizedTest(name = "입력값: \"{0}\", 상금: \"{1}\"")
    void Rank에_따라_적절한_상금을_반환한다(Rank rank, int prize) {
        Assertions.assertThat(rank.getPrize())
                .isEqualTo(prize);
    }
}
