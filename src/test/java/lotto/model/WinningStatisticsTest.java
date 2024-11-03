package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.RankType;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    private WinningStatistics winningStatistics;
    private List<Lotto> lottoList;
    private Lotto winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;

    @Test
    public void 이천원으로_4등_1개와_5등_1개가_당첨되는_경우의_로또_통계와_수익률() {
        purchaseAmount = 2;

        lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))
        );

        winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;

        winningStatistics = new WinningStatistics();
        winningStatistics.calculateRankResults(lottoList, winningNumbers, bonusNumber);
        String earningRate = winningStatistics.calculateEarningRate(purchaseAmount);
        Map<RankType, RankResult> statistics = winningStatistics.getStatistics();

        assertEquals(1, statistics.get(RankType.FOURTH).getCount());
        assertEquals(1, statistics.get(RankType.FIFTH).getCount());
        assertEquals("2750.0", earningRate);
    }

    @Test
    public void 이천원으로_2등_1개와_3등_1개가_당첨되는_경우의_당첨_통계와_수익률() {
        purchaseAmount = 2;

        lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9))
        );

        winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;

        winningStatistics = new WinningStatistics();
        winningStatistics.calculateRankResults(lottoList, winningNumbers, bonusNumber);
        String earningRate = winningStatistics.calculateEarningRate(purchaseAmount);
        Map<RankType, RankResult> statistics = winningStatistics.getStatistics();

        assertEquals(1, statistics.get(RankType.SECOND).getCount());
        assertEquals(1, statistics.get(RankType.THIRD).getCount());
        assertEquals("1.575000.0", earningRate);
    }
}
