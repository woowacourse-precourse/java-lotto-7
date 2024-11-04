package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.LottoDrawMachine;
import lotto.model.LottoWinningStatics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoWinningStaticsTest {
    private LottoDrawMachine lottoDrawMachine;
    private LottoWinningStatics lottoWinningStatics;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 29, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 29, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30)),
                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30))
        );

        lottoDrawMachine = new LottoDrawMachine(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );

        lottoWinningStatics = new LottoWinningStatics(lottos, lottoDrawMachine, lottos.size() * 1000);
    }

    @Test
    void testCalculateStatisticsForFirstPlace() {
        Map<Integer, Integer> matchCountMap = lottoWinningStatics.calculateStatistics();

        assertEquals(4, matchCountMap.get(3).intValue());
        assertEquals(2, matchCountMap.get(4).intValue());
        assertEquals(3, matchCountMap.get(5).intValue());
        assertEquals(0, matchCountMap.get(6).intValue());
        assertEquals(0, matchCountMap.get(7).intValue());
    }

    @Test
    void testCalculateYieldForFirstPlace() {
        double yield = lottoWinningStatics.calculateYield();

        double expectedYield = 51333.333333333336;

        assertEquals(expectedYield, yield, 0.1);
    }

}
