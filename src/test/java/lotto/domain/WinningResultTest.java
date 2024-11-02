package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningResultTest {

    @ParameterizedTest
    @MethodSource("testTotalRate")
    void 총_수익률을_계산할_수_있다(List<WinningPrize> prizes, double expected) {
        WinningResult lottoResult = new WinningResult(prizes);

        double totalRate = lottoResult.getTotalRate();

        assertThat(String.valueOf(totalRate)).isEqualTo(String.valueOf(expected));
    }

    private static Stream<Arguments> testTotalRate() {
        return Stream.of(
                Arguments.of(List.of(WinningPrize.NONE), 0.0),
                Arguments.of(List.of(
                        WinningPrize.FIFTH, WinningPrize.NONE, WinningPrize.NONE, WinningPrize.NONE,
                        WinningPrize.NONE, WinningPrize.NONE, WinningPrize.NONE, WinningPrize.NONE), 62.5),
                Arguments.of(List.of(WinningPrize.FIFTH, WinningPrize.NONE, WinningPrize.NONE), 166.7),
                Arguments.of(List.of(WinningPrize.FIFTH), 500.0)
        );
    }
}