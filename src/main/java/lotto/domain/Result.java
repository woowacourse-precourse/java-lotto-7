package lotto.domain;

public class Result {

    private final int hitCount;
    private final int bonusCount;

    public Result(int hitCount, int bonusCount) {
        this.hitCount = hitCount;
        this.bonusCount = bonusCount;
    }

    public boolean isCountSameAsReward(Reward reward) {
        return reward.compareHitCount(hitCount) && reward.compareBonusCount(hitCount, bonusCount);
    }
}
