package lotto.domain;

import java.util.EnumMap;

public class Result {

    private final int hitCount;
    private final int bonusCount;

    public Result(int hitCount, int bonusCount) {
        this.hitCount = hitCount;
        this.bonusCount = bonusCount;
    }

    public void compareResultToCriterion(EnumMap<Reward, Integer> totalResult, Reward reward) {
        if (reward.compareHitCount(hitCount) && reward.compareBonusCount(hitCount, bonusCount)) {
            int preVal = totalResult.get(reward);
            totalResult.put(reward, ++preVal);
        }
    }
}
