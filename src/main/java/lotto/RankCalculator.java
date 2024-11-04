package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankCalculator {

    private final Map<Rank, Integer> countOfRank;
    private final int cost;

    public RankCalculator(Map<Rank, Integer> countOfRank, int cost) {
        this.countOfRank = countOfRank;
        this.cost = cost;
    }

    public static RankCalculator from(List<Rank> ranks) {
        Map<Rank, Integer> countOfRank = ranks.stream()
                .collect(
                        Collectors.toMap(rank -> rank, rank -> 1, Integer::sum)
                );

        for(var rank : Rank.values()) {
            if(!countOfRank.containsKey(rank)) {
                countOfRank.put(rank, 0);
            }
        }

        return new RankCalculator(countOfRank, ranks.size() * LottoCost.LOTTO_COST_UNIT);
    }

    public Map<Rank, Integer> getCountOfRank() {
        return countOfRank;
    }

    public double getProfit() {
        int totalPrize = countOfRank.entrySet().stream()
                .mapToInt(entry -> {
                    return entry.getKey().getPrize() * entry.getValue();
                })
                .sum();
        return ((double) totalPrize * 100.0 / cost);
    }
}
