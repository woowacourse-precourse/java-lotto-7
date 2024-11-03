package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> matchCount;
    private final double profitRate;

    public LottoResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        this.matchCount = calculateMatchCount(tickets, winningNumbers, bonusNumber);
        this.profitRate = calculateProfitRate(tickets.size() * LottoMachine.PRICE_UNIT);
    }

    private Map<Rank, Integer> calculateMatchCount(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> matchResult = new HashMap<>();
        for (Lotto ticket : tickets) {
            Rank rank = Rank.findRank(ticket.getNumbers(), winningNumbers, bonusNumber);
            matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
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