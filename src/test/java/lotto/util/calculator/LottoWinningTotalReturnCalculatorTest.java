package lotto.util.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import lotto.value.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningTotalReturnCalculatorTest {

    LottoWinningTotalReturnCalculator lottoWinningTotalReturnCalculator;

    @BeforeEach
    void setUp() {
        lottoWinningTotalReturnCalculator = new LottoWinningTotalReturnCalculator();
    }

    @ParameterizedTest
    @MethodSource("calculateReturn")
    void 당첨_통계를_통해서_총_수익률을_계산한다(
            int purchaseAmount,
            Map<Rank, Integer> statistics,
            double expected
    ) {
        double totalReturn = lottoWinningTotalReturnCalculator.calculateReturn(purchaseAmount,
                statistics);
        assertThat(totalReturn).isEqualTo(expected);
    }

    public static Stream<Arguments> calculateReturn() {
        return Stream.of(
                Arguments.of(1000, Map.of(), 0.0),
                Arguments.of(8000, Map.of(Rank.FIFTH_PLACE, 1), 62.5),
                Arguments.of(10000, Map.of(Rank.FIRST_PLACE, 1), 20_000_000.0),
                Arguments.of(10000, Map.of(Rank.FIFTH_PLACE, 2), 100.0)
        );
    }

}