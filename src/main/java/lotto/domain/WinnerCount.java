package lotto.domain;

import lotto.utils.Reward;

public class WinnerCount {

    private final int matchedCount;
    private final boolean hasBonus;

    protected WinnerCount(int matchedCount, boolean hasBonus) {
        this.matchedCount = matchedCount;
        this.hasBonus = hasBonus;
    }

    public static WinnerCount of(int winnerCount, boolean hasBonus) {
        return new WinnerCount(winnerCount, hasBonus);
    }

    protected Integer calculateReward() {
        Reward reward = Reward.getReward(this.matchedCount, this.hasBonus);
        return reward.getPrize();
    }
}
