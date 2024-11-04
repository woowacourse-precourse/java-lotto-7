package lotto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoDrawMachine;
import lotto.model.LottoWinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoWinningStatisticsTest {
    private LottoDrawMachine lottoDrawMachine;
    private LottoWinningStatistics lottoWinningStatistics;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
//                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
//                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
//                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 4, 29, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 4, 29, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30)),
//                new Lotto(Arrays.asList(1, 2, 3, 45, 29, 30))
        );

        lottoDrawMachine = new LottoDrawMachine(
                Arrays.asList(1, 2, 3, 4, 5, 6), // Winning numbers
                7 // Bonus number
        );

        // Assuming the purchase amount is based on the number of tickets
        lottoWinningStatistics = new LottoWinningStatistics(lottos, lottoDrawMachine, lottos.size() * 1000);
    }

    @Test
    void testCalculateStatisticsForFirstPlace() {
        Map<Integer, Integer> matchCountMap = lottoWinningStatistics.calculateStatistics();

        assertEquals(0, matchCountMap.get(3).intValue(), "4개");
        assertEquals(0, matchCountMap.get(4).intValue(), "2개");
        assertEquals(0, matchCountMap.get(5).intValue(), "3개");
        assertEquals(0, matchCountMap.get(6).intValue(), "0");
        assertEquals(2, matchCountMap.get(7).intValue(), "0");
    }

    @Test
    void testCalculateYieldForFirstPlace() {
        double yield = lottoWinningStatistics.calculateYield();

        double expectedYield = 3000000;

        assertEquals(expectedYield, yield, 0.1, "계산 결과 안 맞음");
    }
}
