package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningRule;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoDrawTest {

    private LottoDraw lottoDraw;
    private LottoWinningStatistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new LottoWinningStatistics();
        lottoDraw = new LottoDraw(statistics);
    }

    static Stream<Arguments> winningNumberFactory() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45), 5),
                Arguments.arguments(List.of(1, 2, 3, 4, 44, 45), 4),
                Arguments.arguments(List.of(1, 2, 3, 43, 44, 45), 3),
                Arguments.arguments(List.of(1, 2, 42, 43, 44, 45), 2),
                Arguments.arguments(List.of(1, 41, 42, 43, 44, 45), 1),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("winningNumberFactory")
    public void 로또번호_당첨번호_비교_테스트(List<Integer> numbers, int expected) throws Exception {
        //Given
        WinningNumber winningNumbers = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        //When
        int actual = lottoDraw.compareWinningNumber(lotto, winningNumbers);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> bonusNumberFactory() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), false),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45), true)
        );
    }

    @ParameterizedTest
    @MethodSource("bonusNumberFactory")
    public void 로또번호_보너스번호_비교_테스트(List<Integer> numbers, boolean expected) throws Exception {
        //Given
        WinningNumber winningNumbers = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(45, winningNumbers);
        Lotto lotto = new Lotto(numbers);

        //When
        boolean actual = lottoDraw.compareBonusNumber(lotto, bonusNumber);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> totalPrizeFactory() {
        return Stream.of(
                Arguments.arguments(List.of(LottoRank.FIFTH, LottoRank.FIFTH, LottoRank.FIFTH,
                        LottoRank.FOURTH, LottoRank.FOURTH,
                        LottoRank.THIRD, LottoRank.THIRD,
                        LottoRank.SECOND,
                        LottoRank.FIRST,
                        LottoRank.NONE, LottoRank.NONE))
        );
    }

    @ParameterizedTest
    @MethodSource("totalPrizeFactory")
    public void 총_당첨상금_테스트(List<LottoRank> ranks) throws Exception {
        //Given
        long expected = 0L;
        for (LottoRank rank : ranks) {
            statistics.update(rank);
            expected += LottoWinningRule.getPrize(rank);
        }

        //When
        double actual = lottoDraw.calcTotalPrize();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> returnRateFactory() {
        return Stream.of(
                Arguments.arguments(5000, 8000),
                Arguments.arguments(5000, 1000),
                Arguments.arguments(0, 1000),
                Arguments.arguments(1000, 1000),
                Arguments.arguments(333, 1000)
        );
    }

    @ParameterizedTest
    @MethodSource("returnRateFactory")
    public void 수익률_테스트(long totalPrize, int amountValue) throws Exception {
        //Given
        Amount amount = new Amount(amountValue);
        double expected = (double) totalPrize / amountValue;

        //When
        double actual = lottoDraw.calcReturnRate(totalPrize, amount);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}