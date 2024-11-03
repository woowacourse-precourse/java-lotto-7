package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.util.Constants;

public class LottoResult {
    private final Map<Rank, Integer> matchCount;
    private final double profitRate;

    public LottoResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        this.matchCount = calculateMatchCount(tickets, winningNumbers, bonusNumber);
        this.profitRate = calculateProfitRate(tickets.size() * Constants.PRICE_UNIT);
    }

    private Map<Rank, Integer> calculateMatchCount(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        if (tickets == null || tickets.contains(null)) {
            throw new IllegalArgumentException(Constants.ERROR_NULL_MESSAGE);
        }

        Map<Rank, Integer> matchResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            matchResult.put(rank, 0);
        }
        for (Lotto ticket : tickets) {
            Rank rank = Rank.findRank(ticket.getNumbers(), winningNumbers, bonusNumber);
            if (rank == null) {
                throw new IllegalArgumentException(Constants.ERROR_NULL_MESSAGE);
            }
            matchResult.put(rank, matchResult.get(rank) + 1);
        }
        return matchResult;
    }

    private double calculateProfitRate(int totalCost) {
        int totalPrize = matchCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / totalCost) * 100;
    }

    public Map<Rank, Integer> getMatchCount() {
        return matchCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
