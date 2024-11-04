package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import lotto.domain.*;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.*;

public class ResultCalculatorTest {

    @DisplayName("로또 결과 계산 확인")
    @Test
    void testLottoResult() {
        // given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        ));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        ResultCalculator calculator = new ResultCalculator(lottos, winningLotto);

        // when
        Map<LottoRank, Integer> result = calculator.getResult();
        double yield = calculator.calculateRate(3000);

        // then
        assertEquals(1, result.get(LottoRank.FIRST));
        assertEquals(1, result.get(LottoRank.SECOND));
        assertEquals(1, result.get(LottoRank.FOURTH));
        assertTrue(yield > 0);
    }
}
