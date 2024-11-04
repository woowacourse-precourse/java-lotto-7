package lotto.util.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.value.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningPlaceCalculatorTest {

    LottoWinningPlaceCalculator lottoWinningPlaceCalculator;

    @BeforeEach
    void setUp() {
        lottoWinningPlaceCalculator = new LottoWinningPlaceCalculator();
    }

    @ParameterizedTest
    @MethodSource("calculate")
    void 일치하는_번호의_개수에_따라서_등수가_결정된다(
            int countMatching,
            boolean isMatchingBonus,
            Rank expected
    ) {
        Rank rank = lottoWinningPlaceCalculator.calculate(countMatching, isMatchingBonus);
        assertThat(rank).isEqualTo(expected);
    }

    public static Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of(0, false, Rank.NO_RANK),
                Arguments.of(1, false, Rank.NO_RANK),
                Arguments.of(2, false, Rank.NO_RANK),
                Arguments.of(3, false, Rank.FIFTH_PLACE),
                Arguments.of(4, false, Rank.FOURTH_PLACE),
                Arguments.of(5, false, Rank.THIRD_PLACE),
                Arguments.of(5, true, Rank.SECOND_PLACE),
                Arguments.of(6, false, Rank.FIRST_PLACE)
        );
    }
}