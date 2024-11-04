package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<String, Integer> matchCounts;

    private double totalPriceRate;
    public Statistics() {
        matchCounts = new HashMap<>();
        matchCounts.put("3개 일치", 0);
        matchCounts.put("4개 일치", 0);
        matchCounts.put("5개 일치", 0);
        matchCounts.put("5개 일치, 보너스 볼 일치", 0);
        matchCounts.put("6개 일치", 0);
        totalPriceRate = 0.0;
    }

    public void updateStatistics(int matchCount, boolean isBonus) {
        String matchType = "";

        if (matchCount == 5 && isBonus) {
            matchType = "5개 일치, 보너스 볼 일치";
        }
        if (matchCount >=3  && matchCount<=6 && !isBonus) {
            matchType = matchCount + "개 일치";
        }

        if (!matchType.isEmpty()) {
            matchCounts.put(matchType, matchCounts.get(matchType) + 1);
        }
    }

    public int getMatchCount(String matchType) {
        return matchCounts.getOrDefault(matchType, 0);
    }

    public double getTotalPriceRate(int purchasedTickets) {
        double totalSpent = 1000 * purchasedTickets;
        double totalWon = 0.0;

        totalWon += matchCounts.get("3개 일치") * 5000;
        totalWon += matchCounts.get("4개 일치") * 50000;
        totalWon += matchCounts.get("5개 일치") * 1500000;
        totalWon += matchCounts.get("5개 일치, 보너스 볼 일치") * 30000000;
        totalWon += matchCounts.get("6개 일치") * 2000000000;

        if (totalSpent == 0) {
            return 0;
        }

        totalPriceRate = (totalWon / totalSpent) * 100;
        return Math.round(totalPriceRate * 10.0) / 10.0;
    }
}
