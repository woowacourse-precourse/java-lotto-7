package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    static Stream<Arguments> providePrizeCases() {
        return Stream.of(
                Arguments.of(3, false, Prize.FIFTH),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(6, false, Prize.FIRST),
                Arguments.of(0, false, Prize.MISS)
        );
    }

    @ParameterizedTest(name = "{2}등 -> matchCount={0}, matchBonus={1}")
    @MethodSource("providePrizeCases")
    void 일치결과_보너스일치결과에따른_상금결과_정상_성공(int matchCount, boolean matchBonus, Prize expectedPrize) {
        Prize prize = Prize.of(matchCount, matchBonus);
        assertThat(prize).isEqualTo(expectedPrize);
    }
}