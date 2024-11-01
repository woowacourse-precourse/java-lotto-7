package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningResultTest {
    @ParameterizedTest
    @MethodSource("provideTest")
    void 수익률을_계산하기(List<LottoRank> result, double expected) {
        // given
        final WinningResult winningResult = new WinningResult(result);
        final int purchaseAmount = 1000;

        // when
        double profitRate = winningResult.calculateProfitRate(purchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(List.of(LottoRank.SIXTH), 0.0),
                Arguments.of(List.of(LottoRank.FIFTH), 500.0),
                Arguments.of(List.of(LottoRank.FIFTH, LottoRank.FIFTH), 1000.0),
                Arguments.of(List.of(LottoRank.FIRST, LottoRank.SIXTH), 200_000_000.0)
        );
    }
}