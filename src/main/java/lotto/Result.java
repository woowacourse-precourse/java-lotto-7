package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> rankCountMap;
    private final long totalPrize;

    private Result(Map<Rank, Integer> rankCountMap, long totalPrize) {
        this.rankCountMap = rankCountMap;
        this.totalPrize = totalPrize;
    }

    public static Result calculateResult(List<Lotto> tickets, WinningNumbers winningNumbers) {
        Map<Rank, Integer> rankCountMap = initializeRankCountMap();
        List<Integer> winningNums = winningNumbers.getLotto().getNumbers();
        int bonus = winningNumbers.getBonus();

        for (Lotto ticket : tickets) {
            int matchCount = calculateMatchCount(ticket, winningNums);
            boolean hasBonus = ticket.getNumbers().contains(bonus);
            Rank rank = Rank.of(matchCount, hasBonus);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }

        long totalPrize = calculateTotalPrize(rankCountMap);
        return new Result(rankCountMap, totalPrize);
    }

    private static Map<Rank, Integer> initializeRankCountMap() {
        Map<Rank, Integer> rankCountMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
        return rankCountMap;
    }

    private static int calculateMatchCount(Lotto ticket, List<Integer> winningNums) {
        return (int) ticket.getNumbers().stream()
                .filter(winningNums::contains)
                .count();
    }

    private static long calculateTotalPrize(Map<Rank, Integer> rankCountMap) {
        return rankCountMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getRankCountMap() {
        return rankCountMap;
    }

    public double getYield(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}