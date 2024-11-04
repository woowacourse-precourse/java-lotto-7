package lotto.domain;

public enum Reward {

    HIT_3(3, false, 5000L),
    HIT_4(4, false, 50000L),
    HIT_5(5, false, 1500000L),
    HIT_5_AND_BONUS(5, true, 30000000L),
    HIT_6(6, false, 2000000000L);

    private static final int SECOND_PLACE_BONUS = 1;

    private final int hitCount;
    private final boolean secondPlaceFlag;
    private final long prizeAmount;

    Reward(int hitCount, boolean secondPlaceFlag, long prizeAmount) {
        this.hitCount = hitCount;
        this.secondPlaceFlag = secondPlaceFlag;
        this.prizeAmount = prizeAmount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isSecondPlace() {
        return secondPlaceFlag;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public boolean compareHitCount(int hitCount) {
        return hitCount == this.hitCount;
    }

    public boolean compareBonusCount(int hitCount, int bonusCount) {
        boolean secondPlaceFlag = (hitCount == HIT_5_AND_BONUS.getHitCount()) && (bonusCount == SECOND_PLACE_BONUS);

        return secondPlaceFlag == this.secondPlaceFlag;
    }
}
