package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoPrizeTest {

    @ParameterizedTest(name = "({index}) number match : {0} / bonus number match : {1} ==> prize : {2}")
    @MethodSource("argumentsForAvailableMatch")
    void 의도한_로또_당첨_결과를_반환한다(
            // given
            int givenNumberMatchCount, boolean givenIsBonusNumberMatch, LottoPrize expected
    ) {
        // when
        LottoPrize result = LottoPrize.match(givenNumberMatchCount, givenIsBonusNumberMatch);

        // then
        assertThat(result).isEqualTo(expected);
    }
    static Stream<Arguments> argumentsForAvailableMatch() {
        return Stream.of(
                Arguments.of(0, true, LottoPrize.MATCH_NONE),
                Arguments.of(0, false, LottoPrize.MATCH_NONE),
                Arguments.of(1, true, LottoPrize.MATCH_NONE),
                Arguments.of(1, false, LottoPrize.MATCH_NONE),
                Arguments.of(2, true, LottoPrize.MATCH_NONE),
                Arguments.of(2, false, LottoPrize.MATCH_NONE),
                Arguments.of(3, true, LottoPrize.MATCH_THREE),
                Arguments.of(3, false, LottoPrize.MATCH_THREE),
                Arguments.of(4, true, LottoPrize.MATCH_FOUR),
                Arguments.of(4, false, LottoPrize.MATCH_FOUR),
                Arguments.of(5, false, LottoPrize.MATCH_FIVE),
                Arguments.of(5, true, LottoPrize.MATCH_FIVE_AND_BONUS),
                Arguments.of(6, true, LottoPrize.MATCH_SIX),
                Arguments.of(6, false, LottoPrize.MATCH_SIX)
        );
    }
}