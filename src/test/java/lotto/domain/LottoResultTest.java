package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("testTotalRate")
    void 총_수익률을_계산할_수_있다(List<LottoPrize> prizes, double expected) {
        LottoResult lottoResult = new LottoResult(prizes);

        double totalRate = lottoResult.getTotalRate();
        assertThat(totalRate).isEqualTo(expected);
//        assertThat(new BigDecimal("0.00")).isEqualTo(new BigDecimal("0.00"));
    }

    private static Stream<Arguments> testTotalRate() {
        return Stream.of(
                Arguments.of(List.of(LottoPrize.NONE), 0.0),
                Arguments.of(
                        List.of(LottoPrize.FIFTH, LottoPrize.NONE, LottoPrize.NONE, LottoPrize.NONE, LottoPrize.NONE,
                                LottoPrize.NONE, LottoPrize.NONE, LottoPrize.NONE), 62.5),
                Arguments.of(List.of(LottoPrize.FIFTH, LottoPrize.NONE, LottoPrize.NONE), 166.7),
                Arguments.of(List.of(LottoPrize.FIFTH), 500.0)

        );
    }
}