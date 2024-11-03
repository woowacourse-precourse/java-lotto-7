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

class LottoContainerTest {

    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("발행된 로또 저장 테스트")
    @Test
    void 발행된_로또_저장_테스트() {
        final List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        final LottoContainer container = new LottoContainer(lottos);

        Assertions.assertEquals(container.getSize(), lottos.size());
    }

    @ParameterizedTest
    @MethodSource("로또구매데이터")
    void 로또_덩첨_결과_테스트(final List<Lotto> lotteries, final BigDecimal expectedSum) {
        final LottoContainer lottoContainer = new LottoContainer(lotteries);

        Assertions.assertEquals(
                lottoContainer.verifyResults(winningLotto).getSum(), expectedSum);
    }

    static Stream<Arguments> 로또구매데이터() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7))
                        ),
                        LottoResult.FIRST.getWinningAmount().add(LottoResult.SECOND.getWinningAmount())
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                                new Lotto(List.of(5, 6, 7, 8, 9, 10))
                        ),
                        BigDecimal.ZERO
                )
        );
    }
}