package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
    private final List<Lotto> lottos;
    private Map<Winning, Integer> matchCounts;
    private int totalPrize = 0;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
        this.matchCounts = new HashMap<>();
        initializeWinningStatistics();
    }

    private void initializeWinningStatistics() {
        for (Winning winning : Winning.values()) {
            matchCounts.put(winning, 0);
        }
    }

    public Map<Winning, Integer> getMatchCounts() {
        return matchCounts;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addToTotalPrize(int prize) {
        totalPrize += prize;
    }

    public void updateWinningStatistics(Winning winning) {
        matchCounts.put(winning, matchCounts.get(winning) + 1);
    }

    public double calculateYield(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}
