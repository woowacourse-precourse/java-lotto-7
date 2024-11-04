package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.enums.Stats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatsServiceTest {
    private StatsService statsService;

    @BeforeEach
    void setUp() {
        statsService = new StatsService();
    }

    @Test
    void 통계_계산_테스트() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Player player = new Player(winningLotto, bonusNumber);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)), // 3개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)) // 5개 당첨
        );

        statsService.calculateStats(lottos, player);

        Map<Stats, Integer> statsCount = statsService.getStatsCount();
        assertEquals(1, statsCount.get(Stats.THREE_MATCH));
        assertEquals(1, statsCount.get(Stats.FOUR_MATCH));
        assertEquals(1, statsCount.get(Stats.FIVE_MATCH));
        assertEquals(0, statsCount.get(Stats.FIVE_MATCH_BONUS));
        assertEquals(0, statsCount.get(Stats.SIX_MATCH));
    }

    @Test
    void 보너스_당첨인_경우_통계_계산_테스트() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Player player = new Player(winningLotto, bonusNumber);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)), // 3개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)) // 5개, 보너스 당첨
        );

        statsService.calculateStats(lottos, player);

        Map<Stats, Integer> statsCount = statsService.getStatsCount();
        assertEquals(1, statsCount.get(Stats.THREE_MATCH));
        assertEquals(1, statsCount.get(Stats.FOUR_MATCH));
        assertEquals(0, statsCount.get(Stats.FIVE_MATCH));
        assertEquals(1, statsCount.get(Stats.FIVE_MATCH_BONUS));
        assertEquals(0, statsCount.get(Stats.SIX_MATCH));
    }

    @Test
    void 수익률_계산_테스트() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Player player = new Player(winningLotto, bonusNumber);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)), // 3개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)) // 5개, 보너스 당첨
        );

        statsService.calculateStats(lottos, player);

        int purchaseAmount = 3000;
        double expectedProfitRate =
                (Stats.THREE_MATCH.getPrize() + Stats.FOUR_MATCH.getPrize() + Stats.FIVE_MATCH_BONUS.getPrize())
                        / (double) purchaseAmount * 100;
        expectedProfitRate = Math.round(expectedProfitRate * 100) / 100.0;
        
        double actualProfitRate = statsService.calculateProfitRate(purchaseAmount);

        assertEquals(expectedProfitRate, actualProfitRate);
    }
}
