package lotto.function.winning.checker.processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.util.calculator.LottoMatchingCountCalculator;
import lotto.util.calculator.LottoWinningPlaceCalculator;
import lotto.value.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningPlaceCalculateProcessorTest {

    LottoWinningPlaceCalculateProcessor lottoWinningPlaceCalculateProcessor;

    @BeforeEach
    void setUp() {
        lottoWinningPlaceCalculateProcessor = new LottoWinningPlaceCalculateProcessor(
                new LottoWinningPlaceCalculator(), new LottoMatchingCountCalculator());
    }

    @ParameterizedTest
    @MethodSource("calculate")
    void 로또_당첨_등수를_계산한다(WinningLotto winningLotto, Lotto lotto, Rank expected) {
        Rank rank = lottoWinningPlaceCalculateProcessor.calculate(winningLotto, lotto);
        assertThat(rank).isEqualTo(expected);
    }

    public static Stream<Arguments> calculate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(new WinningLotto(lotto, new BonusLotto(7)),
                        lotto,
                        Rank.FIRST_PLACE),
                Arguments.of(new WinningLotto(
                                new Lotto(List.of(1, 2, 3, 11, 22, 33)),
                                new BonusLotto(7)
                        ),
                        lotto,
                        Rank.FIFTH_PLACE),
                Arguments.of(new WinningLotto(
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)), new BonusLotto(6)
                        ),
                        lotto,
                        Rank.SECOND_PLACE),
                Arguments.of(new WinningLotto(
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)), new BonusLotto(7)
                        ),
                        lotto,
                        Rank.THIRD_PLACE),
                Arguments.of(new WinningLotto(
                                new Lotto(List.of(11, 22, 33, 44, 14, 15)), new BonusLotto(8)),
                        lotto,
                        Rank.NO_RANK)
        );
    }

    @ParameterizedTest
    @MethodSource("calculateAll")
    void 모든_로또를_대상으로_당첨_등수를_계산한다(
            WinningLotto winningLotto,
            List<Lotto> lottoList,
            Map<Rank, Integer> expected
    ) {
        Map<Rank, Integer> rankIntegerMap =
                lottoWinningPlaceCalculateProcessor.calculateAll(winningLotto, lottoList);
        assertThat(rankIntegerMap).isEqualTo(expected);
    }

    public static Stream<Arguments> calculateAll() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(new WinningLotto(lotto, new BonusLotto(7)),
                        List.of(lotto, new Lotto(List.of(12, 23, 13, 14, 15, 16))),
                        Map.of(Rank.FIRST_PLACE, 1, Rank.NO_RANK, 1)),
                Arguments.of(new WinningLotto(lotto, new BonusLotto(7)),
                        List.of(lotto, lotto),
                        Map.of(Rank.FIRST_PLACE, 2))
        );
    }
}