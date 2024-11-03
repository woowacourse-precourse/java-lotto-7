package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private Map<String, Integer> results = new HashMap<>();

    private int totalPrize = 0;

    public void addResult(int matchCount, boolean bonusMatch) {
        String rank = getRank(matchCount, bonusMatch);
        if (rank != null) {
            results.put(rank, results.getOrDefault(rank, 0) + 1);
            totalPrize += getPrize(rank);
        }
    }

    private String getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return "1등";
        }
        if (matchCount == 5 && bonusMatch) {
            return "2등";
        }
        if (matchCount == 5) {
            return "3등";
        }
        if (matchCount == 4) {
            return "4등";
        }
        if (matchCount == 3) {
            return "5등";
        }
        return null;
    }

    private int getPrize(String rank) {
        switch (rank) {
            case "1등":
                return 2000000000;
            case "2등":
                return 30000000;
            case "3등":
                return 1500000;
            case "4등":
                return 50000;
            case "5등":
                return 5000;
            default:
                return 0;
        }
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
