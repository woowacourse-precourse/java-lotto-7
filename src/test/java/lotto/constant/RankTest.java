package lotto.constant;

import static lotto.domain.constant.Rank.FIFTH;
import static lotto.domain.constant.Rank.FIFTH_WITH_BONUS;
import static lotto.domain.constant.Rank.FOURTH;
import static lotto.domain.constant.Rank.SIX;
import static lotto.domain.constant.Rank.THIRDS;
import static lotto.domain.constant.Rank.calculateReward;
import static lotto.domain.constant.Rank.contains;
import static lotto.domain.constant.Rank.getRank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.domain.constant.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void _3이상_6이하의_수는_당첨순위에_포함되어있다(int matchCount) {
        //given
        //when
        boolean hasElement = contains(matchCount);
        //then
        assertThat(hasElement).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 8})
    void _2이하_7이상의_수는_당첨순위에_포함되지_않는다(int invalidMatchCount) {
        //given
        //when
        boolean hasElement = contains(invalidMatchCount);
        //then
        assertThat(hasElement).isFalse();
    }

    @ParameterizedTest
    @MethodSource("provideMatchCountAndBonus")
    void 순위를_매길수있는_상태값이_들어오면_그에맞는_순위를_반환한다(int matchCount, boolean isMatchBonus, Rank expectedRank) {
        //given
        //when
        Rank rank = getRank(matchCount, isMatchBonus);
        //then
        assertThat(rank).isNotNull();
        assertThat(rank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidMatchCountAndBonus")
    void 순위를_매길수없는_상태값이_들어오면_예외가_발생한다(int matchCount, boolean isMatchBonus) {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            getRank(matchCount, isMatchBonus);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRanks")
    void 각_순위에맞는_보상금액을_연산한다(Rank rank, int matchCount, int expectedReward) {
        //given
        //when
        int reward = calculateReward(rank, matchCount);
        //then
        assertThat(reward).isEqualTo(expectedReward);
    }

    private static Stream<Arguments> provideRanks() {
        return Stream.of(
                Arguments.of(THIRDS, 2, 10_000),
                Arguments.of(FOURTH, 2, 100_000),
                Arguments.of(FIFTH, 2, 3_000_000),
                Arguments.of(FIFTH_WITH_BONUS, 2, 60_000_000),
                Arguments.of(SIX, 1, 2_000_000_000)
        );
    }


    private static Stream<Arguments> provideMatchCountAndBonus() {
        return Stream.of(
                Arguments.of(3, false, THIRDS),
                Arguments.of(4, false, FOURTH),
                Arguments.of(5, false, FIFTH),
                Arguments.of(4, true, FIFTH_WITH_BONUS),
                Arguments.of(6, false, SIX)
        );
    }

    private static Stream<Arguments> provideInvalidMatchCountAndBonus() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(2, true),
                Arguments.of(1, true)
        );
    }

}