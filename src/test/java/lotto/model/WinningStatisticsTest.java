package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStatisticsTest {
    private static final List<Integer> testLotto = List.of(1, 2, 3, 4, 5, 6);
    private WinningStatistics testWinningStatistics;

    @BeforeEach
    void beforeEach() {
        testWinningStatistics = new WinningStatistics();
    }

    @ParameterizedTest
    @MethodSource("testMatchCountArgs")
    void 당첨번호_개수기_테스트(List<Integer> testLottoNumbers, List<Integer> testWinningNumbers, int expected) {
        assertThat(testWinningStatistics.getMatchCount(testLottoNumbers, testWinningNumbers))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testBonusMatchArgs")
    void 보너스_번호_적중_여부_테스트(List<Integer> testLottoNumbers, WinningNumbers testWinningNumbers, boolean expected) {
        assertThat(testWinningStatistics.checkBonusMatch(testLottoNumbers, testWinningNumbers.getBonusNumber()))
                .isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("testUpdateArgs")
    void 당첨_갱신_테스트(int testMatchCount, boolean testIsBonusMatch, Rank rank, int count) {
        testWinningStatistics.updateWinningStatistics(testMatchCount, testIsBonusMatch);
        Map<Rank, Integer> testMap = testWinningStatistics.getWinningStatistics();
        assertThat(testMap.get(rank)).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("testGetPrizeArgs")
    void 총_당첨금_계산_테스트(int testMatchCount, boolean testIsBonusMatch, long totalPrize) {
        testWinningStatistics.updateWinningStatistics(testMatchCount, testIsBonusMatch);
        assertThat(testWinningStatistics.getTotalPrize()).isEqualTo(totalPrize);
    }

    @ParameterizedTest
    @MethodSource("testGetRateOfReturnArgs")
    void 수익률_계산_테스트(int testMatchCount, boolean testIsBonusMatch, double rateOfReturn) {
        testWinningStatistics.updateWinningStatistics(testMatchCount, testIsBonusMatch);
        Money money = new Money(10000);
        assertThat(testWinningStatistics.getRateOfReturn(money)).isEqualTo(rateOfReturn);
    }

    static Stream<Arguments> testGetRateOfReturnArgs() {
        return Stream.of(
                Arguments.arguments(1, false, (double) 0),
                Arguments.arguments(3, false, (double) 50),
                Arguments.arguments(5, false, (double) 15000)
        );
    }

    static Stream<Arguments> testGetPrizeArgs() {
        return Stream.of(
                Arguments.arguments(1, false, 0),
                Arguments.arguments(5, true, 30000000)
        );
    }

    static Stream<Arguments> testMatchCountArgs() {
        return Stream.of(
                Arguments.arguments(testLotto, List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(testLotto, List.of(2, 3, 4, 5, 6, 7), 5),
                Arguments.arguments(testLotto, List.of(3, 4, 5, 6, 7, 8), 4),
                Arguments.arguments(testLotto, List.of(4, 5, 6, 7, 8, 9), 3)
        );
    }

    static Stream<Arguments> testBonusMatchArgs() {
        return Stream.of(
                Arguments.arguments(testLotto, new WinningNumbers(List.of(2, 3, 4, 5, 6, 7), 1), true),
                Arguments.arguments(testLotto, new WinningNumbers(List.of(1, 2, 3, 4, 5, 7), 6), true),
                Arguments.arguments(testLotto, new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7), false),
                Arguments.arguments(testLotto, new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 8), false)
        );
    }

    static Stream<Arguments> testUpdateArgs() {
        return Stream.of(
                Arguments.arguments(3, false, Rank.FIFTH, 1),
                Arguments.arguments(4, false, Rank.FOURTH, 1),
                Arguments.arguments(5, false, Rank.THIRD, 1),
                Arguments.arguments(5, true, Rank.SECOND, 1),
                Arguments.arguments(6, false, Rank.FIRST, 1)
        );
    }
}