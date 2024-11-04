package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("일치하는 개수롸 보너스 성공 여부에 따라 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("providerRankByMatchingCountAndBonusSuccess")
    void returnRankByMatchingCountAndBonusSuccess(int matchingCount, boolean successBonus, Rank expectedRank) {
        Rank rank = with(matchingCount, successBonus);

        assertThat(rank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> providerRankByMatchingCountAndBonusSuccess() {
        return Stream.of(
                Arguments.of(6, true, FIRST),
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, true, FOURTH),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(2, true, NONE),
                Arguments.of(2, false, NONE),
                Arguments.of(1, true, NONE),
                Arguments.of(1, false, NONE)
        );
    }

}
