package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.enums.Stats;

public class StatsService {
    private final Map<Stats, Integer> statsCount = new HashMap<>();

    public StatsService() {
        for (Stats stat : Stats.values()) {
            statsCount.put(stat, 0);
        }
    }

    public void calculateStats(List<Lotto> lottos, Player player) {
        for (Lotto lotto : lottos) {
            Stats stat = statsForLotto(lotto, player);
            if (stat != null) {
                statsCount.put(stat, statsCount.get(stat) + 1);
            }
        }
    }

    public Stats statsForLotto(Lotto lotto, Player player) {
        Lotto winningLotto = player.getWinningLotto();
        int bonusNumber = player.getBonusNumber();

        int matchCount = calculateMatchCount(lotto, winningLotto);
        boolean bonusMatch = isBonusMatch(lotto, bonusNumber);
        return Stats.valueOf(matchCount, bonusMatch);
    }

    private int calculateMatchCount(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private boolean isBonusMatch(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Map<Stats, Integer> getStatsCount() {
        return statsCount;
    }
}
