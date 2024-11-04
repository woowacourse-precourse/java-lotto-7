package lotto.model.match;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @ParameterizedTest
    @MethodSource("provideMatchInformation")
    void 보너스_일치_여부에_따라_일치_개수가_달라진다(int equalCount, boolean isBonus,
                                   MatchInformation matchInformation, boolean isEqual) {
        Match match = Match.of(equalCount, isBonus);
        assertThat(match.isEqualTo(matchInformation)).isEqualTo(isEqual);
    }

    @Test
    void 매치_정보와_일치하는지_확인한다() {
        Match match = Match.of(6, false);
        boolean isEqual = match.isEqualTo(MatchInformation.SIX_MATCH);
        assertThat(isEqual).isTrue();
    }

    private static Stream<Arguments> provideMatchInformation() {
        return Stream.of(
                Arguments.of(2, true, MatchInformation.THREE_MATCH, true),
                Arguments.of(2, false, MatchInformation.THREE_MATCH, false)
        );
    }
}