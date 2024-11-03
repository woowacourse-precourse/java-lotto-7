package lotto.constant;

public enum Reward {
    NO_REWARD(0),
    THREE_REWARD(5_000),
    FOUR_REWARD(50_000),
    FIVE_REWARD(1_500_000),
    FIVE_WITH_BONUS_REWARD(30_000_000),
    SIX_REWARD(2_000_000_000);

    private final long rewardAmount;

    Reward(int rewardAmount){
        this.rewardAmount = rewardAmount;
    }

    public long value(){
        return rewardAmount;
    }

}
