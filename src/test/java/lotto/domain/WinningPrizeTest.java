package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningPrizeTest {
    @ParameterizedTest
    @MethodSource("getLottoPrize")
    void 로또번호와_보너스번호_일치갯수에_맞는_당첨을_반환한다(int matches, int bonus, WinningPrize expected) {
        WinningPrize prize = WinningPrize.getPrize(matches, bonus);

        assertThat(prize).isEqualTo(expected);
    }

    private static Stream<Arguments> getLottoPrize() {
        return Stream.of(
                Arguments.of(6, 0, WinningPrize.FIRST),
                Arguments.of(5, 1, WinningPrize.SECOND),
                Arguments.of(5, 0, WinningPrize.THIRD),
                Arguments.of(4, 0, WinningPrize.FOURTH),
                Arguments.of(3, 0, WinningPrize.FIFTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getLottoPrize2")
    void 조건보다_보너스_점수가_있을_경우라도_매칭된다(int matches, int bonus, WinningPrize expected) {
        WinningPrize prize = WinningPrize.getPrize(matches, bonus);

        assertThat(prize).isEqualTo(expected);
    }

    private static Stream<Arguments> getLottoPrize2() {
        return Stream.of(
                Arguments.of(6, 1, WinningPrize.FIRST),
                Arguments.of(4, 1, WinningPrize.FOURTH),
                Arguments.of(3, 1, WinningPrize.FIFTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getLottoPrize3")
    void 만족하는_게_없을_경우_None을_반환한다(int matches, int bonus, WinningPrize expected) {
        WinningPrize prize = WinningPrize.getPrize(matches, bonus);

        assertThat(prize).isEqualTo(expected);
    }

    private static Stream<Arguments> getLottoPrize3() {
        return Stream.of(
                Arguments.of(2, 1, WinningPrize.NONE),
                Arguments.of(1, 0, WinningPrize.NONE)
        );
    }
}