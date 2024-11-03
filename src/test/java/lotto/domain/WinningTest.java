package lotto.domain;

import static lotto.domain.Winning.FIFTH;
import static lotto.domain.Winning.FIRST;
import static lotto.domain.Winning.FOURTH;
import static lotto.domain.Winning.NONE;
import static lotto.domain.Winning.SECOND;
import static lotto.domain.Winning.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {
    @DisplayName("로또 번호가 당첨 로또 및 보너스 번호와 일치하는 개수에 따라 당첨 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource
    void returnWinningByTotalMatchingNumber(int totalMatchingNumber, boolean withBonusNumber, Winning expected) {
        Winning actual = Winning.tellWinningBy(totalMatchingNumber, withBonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> returnWinningByTotalMatchingNumber() {
        return Stream.of(
                Arguments.of(0, false, NONE), Arguments.of(0, true, NONE),
                Arguments.of(1, false, NONE), Arguments.of(1, true, NONE),
                Arguments.of(2, false, NONE), Arguments.of(2, true, NONE),
                Arguments.of(3, false, FIFTH), Arguments.of(3, true, FIFTH),
                Arguments.of(4, false, FOURTH), Arguments.of(4, true, FOURTH),
                Arguments.of(5, false, THIRD), Arguments.of(5, true, SECOND),
                Arguments.of(6, false, FIRST)
        );
    }

    @DisplayName("각 당첨 등수의 당첨 개수에 따라 총 상금을 계산한다.")
    @ParameterizedTest
    @MethodSource
    void calculateTotalPrizeOf(Map<Winning, Integer> winningCounts, BigInteger expected) {
        BigInteger actual = Winning.tellTotalPrize(winningCounts);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> calculateTotalPrizeOf() {
        return Stream.of(
                Arguments.of(Map.of(FIRST, 0, SECOND, 0, THIRD, 0, FOURTH, 0, FIFTH, 0, NONE, 0),
                        new BigInteger("0")),
                Arguments.of(Map.of(FIRST, 0, SECOND, 0, THIRD, 3, FOURTH, 1, FIFTH, 1, NONE, 0),
                        new BigInteger("4555000")),
                Arguments.of(Map.of(FIRST, 2, SECOND, 1, THIRD, 2, FOURTH, 3, FIFTH, 2, NONE, 3),
                        new BigInteger("4033160000")),
                Arguments.of(Map.of(FIRST, 1, SECOND, 0, THIRD, 0, FOURTH, 2, FIFTH, 5, NONE, 10),
                        new BigInteger("2000125000"))
        );
    }
}