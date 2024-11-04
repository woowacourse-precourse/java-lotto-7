package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private Map<Integer, Integer> results = new HashMap<>();

    private int totalPrize = 0;

    public void addResult(int matchCount, boolean bonusMatch) {
        int rank = getRank(matchCount, bonusMatch);
        if (rank > 0) {
            results.put(rank, results.getOrDefault(rank, 0) + 1);
            totalPrize += getPrize(rank);
        }
    }

    private int getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    private int getPrize(int rank) {
        if (rank == 1) {
            return LottoReward.MATCH_6_REWARD.getReward();
        }
        if (rank == 2) {
            return LottoReward.MATCH_5_BONUS_REWARD.getReward();
        }
        if (rank == 3) {
            return LottoReward.MATCH_5_REWARD.getReward();
        }
        if (rank == 4) {
            return LottoReward.MATCH_4_REWARD.getReward();
        }
        if (rank == 5) {
            return LottoReward.MATCH_3_REWARD.getReward();
        }
        return 0;
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
