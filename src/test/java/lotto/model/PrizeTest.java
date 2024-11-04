package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizeTest {
    @ParameterizedTest
    @MethodSource("providePrizeTestArguments")
    @DisplayName("조건에 맞는 등수를 반환한다.")
    void testReturnProperPrizeForGivenCondition(int matchedCount, boolean hasBonus, Prize expectedPrize) {
        Prize prize = Prize.getPrize(matchedCount, hasBonus);
        assertThat(prize).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> providePrizeTestArguments() {
        return Stream.of(
                Arguments.of(1, false, Prize.NON),
                Arguments.of(1, true, Prize.NON),
                Arguments.of(2, false, Prize.NON),
                Arguments.of(2, true, Prize.NON),
                Arguments.of(3, false, Prize.FIFTH),
                Arguments.of(3, true, Prize.FIFTH),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(4, true, Prize.FOURTH),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(6, false, Prize.FIRST)
        );
    }

}
