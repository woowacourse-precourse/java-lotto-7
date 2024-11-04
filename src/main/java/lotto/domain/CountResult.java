package lotto.domain;

import lotto.utils.Reward;

public class CountResult {

    private final int matchedCount;
    private final boolean hasBonus;

    protected CountResult(int matchedCount, boolean hasBonus) {
        this.matchedCount = matchedCount;
        this.hasBonus = hasBonus;
    }

    public static CountResult of(int winnerCount, boolean hasBonus) {
        return new CountResult(winnerCount, hasBonus);
    }

    protected Integer calculateReward() {
        Reward reward = Reward.getReward(this.matchedCount, this.hasBonus);
        return reward.getPrize();
    }
}
