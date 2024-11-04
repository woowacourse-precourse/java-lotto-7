package lotto.service;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    public void 당첨_통계_계산_테스트() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        );
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 2, 3, 4, 5, 6), 7);

        int[] matchCounts = lottoService.calculateStatistics(lottos, winningNumber);
        assertArrayEquals(new int[]{0, 1, 0, 1, 1}, matchCounts);
    }

    @Test
    public void 수익률_계산_테스트() {
        Money money = new Money(10000);
        int[] matchCounts = {0, 0, 1, 0, 0};

        double yield = lottoService.calculateYield(money, matchCounts);
        assertEquals(15000.0, yield);
    }
}
