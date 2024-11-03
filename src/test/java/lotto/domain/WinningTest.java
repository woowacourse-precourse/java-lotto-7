package lotto.domain;

import static lotto.domain.Winning.FIFTH;
import static lotto.domain.Winning.FIRST;
import static lotto.domain.Winning.FOURTH;
import static lotto.domain.Winning.NONE;
import static lotto.domain.Winning.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {
    @DisplayName("로또 번호가 일치하는 개수에 따라 당첨 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource
    void returnWinningByTotalMatchingNumber(int totalMatchingNumber, Winning expected) {
        Winning actual = Winning.tellWinningBy(totalMatchingNumber);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> returnWinningByTotalMatchingNumber() {
        return Stream.of(
                Arguments.of(6, FIRST),
                Arguments.of(5, THIRD),
                Arguments.of(4, FOURTH),
                Arguments.of(3, FIFTH),
                Arguments.of(2, NONE),
                Arguments.of(1, NONE),
                Arguments.of(0, NONE)
        );
    }

    @DisplayName("로또 번호가 일치하는 개수 리스트에 대응되는 당첨 등수 리스트를 반환한다.")
    @ParameterizedTest
    @MethodSource
    void returnWinningsByTotalMatchingNumbers(List<Integer> totalMatchingNumbers, List<Winning> expected) {
        List<Winning> actual = Winning.tellWinningBy(totalMatchingNumbers);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> returnWinningsByTotalMatchingNumbers() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 3, 6, 1), List.of(FOURTH, THIRD, FIFTH, FIRST, NONE)),
                Arguments.of(List.of(0, 1, 2, 0), List.of(NONE, NONE, NONE, NONE))
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
                Arguments.of(Map.of(FIRST, 0, THIRD, 0, FOURTH, 0, FIFTH, 0, NONE, 0), new BigInteger("0")),
                Arguments.of(Map.of(FIRST, 0, THIRD, 3, FOURTH, 1, FIFTH, 1, NONE, 0), new BigInteger("4555000")),
                Arguments.of(Map.of(FIRST, 1, THIRD, 0, FOURTH, 2, FIFTH, 5, NONE, 10), new BigInteger("2000125000"))
        );
    }
}