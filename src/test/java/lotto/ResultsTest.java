package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultsTest {

    @DisplayName("당첨금액 종합 테스트")
    @Test
    void 당첨_금액_합계_테스트() {
        final List<LottoResult> lottoResults = List.of(LottoResult.FIRST, LottoResult.SECOND, LottoResult.NONE);
        final Results results = new Results(lottoResults);

        Assertions.assertEquals(results.getSum(),
                LottoResult.FIRST.getWinningAmount().add(LottoResult.SECOND.getWinningAmount()));
    }


    @DisplayName("이익률 테스트")
    @ParameterizedTest
    @MethodSource("로또결과데이터")
    void 이익률_테스트(final LottoPayment lottoPayment, final Results results, final BigDecimal expectedProfitRatio) {
        Assertions.assertEquals(
                results.getProfitRatio(lottoPayment),
                expectedProfitRatio
        );
    }

    static Stream<Arguments> 로또결과데이터() {
        return Stream.of(
                Arguments.of(
                        new LottoPayment(new BigDecimal(2000)),
                        new Results(List.of(LottoResult.NONE, LottoResult.NONE)),
                        new BigDecimal(0)
                ),
                Arguments.of(
                        new LottoPayment(new BigDecimal(2000)),
                        new Results(List.of(LottoResult.FIFTH, LottoResult.FIFTH)),
                        new BigDecimal(500)
                ),
                Arguments.of(
                        new LottoPayment(new BigDecimal(4000)),
                        new Results(List.of(LottoResult.FIRST, LottoResult.FIRST, LottoResult.NONE, LottoResult.NONE)),
                        new BigDecimal("100000000")
                )
        );
    }
}