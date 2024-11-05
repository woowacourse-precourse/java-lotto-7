package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return lottos.size();
    }

    public Map<Rank, Integer> calculateStatistics(WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.calculateRank(lotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    public double calculateProfitRate(Map<Rank, Integer> rankCounts, int purchaseAmount) {
        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        double rate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 100) / 100.0;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
