package lotto.domain.rank;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("랭크 테스트")
    @ParameterizedTest
    @MethodSource("provide")
    void 랭크_테스트(int count, boolean isBonus, Rank expected) {
        Rank rank = Rank.find(count, isBonus);

        assertThat(rank).isEqualTo(expected);
    }

    static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(0, false, Rank.NONE),
                Arguments.of(1, false, Rank.NONE),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }
}
