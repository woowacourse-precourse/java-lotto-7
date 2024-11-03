package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticsCalculatorTest {
    private StatisticsCalculator statisticsCalculator;
    private List<Lotto> lottoList;
    private Lotto winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;

    @BeforeEach
    public void setUp() {
        statisticsCalculator = new StatisticsCalculator();
    }

    @Test
    public void 이천원으로_4등_1개와_5등_1개가_당첨되는_경우의_로또_통계와_수익률() {
        purchaseAmount = 2;

        lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 10, 13, 15)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12));
        bonusNumber = 7;

        Map<RankType, RankResult> statistics =
            statisticsCalculator.calculateStatistics(lottoList, winningNumbers, bonusNumber);
        String earningRate = statisticsCalculator.calculateEarningRate(purchaseAmount);

        assertEquals(1, statistics.get(RankType.FOURTH).getCount());
        assertEquals(1, statistics.get(RankType.FIFTH).getCount());
        assertEquals("2750.0", earningRate);
    }

    @Test
    public void 이천원으로_2등_1개와_3등_1개가_당첨되는_경우의_당첨_통계와_수익률() {
        purchaseAmount = 2;

        lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );


        winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        bonusNumber = 15;

        Map<RankType, RankResult> statistics =
            statisticsCalculator.calculateStatistics(lottoList, winningNumbers, bonusNumber);
        String earningRate = statisticsCalculator.calculateEarningRate(purchaseAmount);

        assertEquals(1, statistics.get(RankType.SECOND).getCount());
        assertEquals(1, statistics.get(RankType.THIRD).getCount());
        assertEquals("1575000.0", earningRate);
    }
}
