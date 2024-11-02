package lotto.models;

import lotto.models.constants.RewardTable;

import java.util.HashMap;
import java.util.Map;

public class LottoResults {
    private final static int DEFAULT_MATCH_VALUE = 0;
    private final Map<RewardTable, Integer> matches = new HashMap<>();

    private RewardTable getMatchKey(int matchingNumbers) {
        RewardTable[] rewardTableKeys = RewardTable.values();
        for (RewardTable key : rewardTableKeys) {
            if (key.getMatches() == matchingNumbers) {
                return key;
            }
        }
        return null;
    }

    public void recordMatch(int matchingNumbers) {
        if (matchingNumbers < 3) {
            return;
        }
        RewardTable matchTier = getMatchKey(matchingNumbers);
        this.matches.put(matchTier, this.matches.getOrDefault(matchTier, 0) + 1);
    }

    public long calculateRewards() {
        long rewardSum = 0;
        RewardTable[] rewardTableKeys = RewardTable.values();
        for (RewardTable key : rewardTableKeys) {
            if (this.matches.get(key) != null) {
                rewardSum += (long) this.matches.get(key) * key.getRewardAmount();
            }
        }
        return rewardSum;
    }

    public int getMatchValue(RewardTable key) {
        if (this.matches.containsKey(key)) {
            return this.matches.get(key);
        }
        return DEFAULT_MATCH_VALUE;
    }
}
