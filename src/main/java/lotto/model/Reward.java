package lotto.model;

public enum Reward {
    FIRST(6,false,2_000_000_000),
    SECOND(5,true,30_000_000),
    THIRD(5,false,1_500_000),
    FOURTH(4,false,50_000),
    FIFTH(3,false,5_000),
    NONE(0,false,0);

    private final int count;
    private final boolean bonus;
    private final int prize;

    Reward(int count, boolean bonus, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Reward getRank(int count, boolean bonus){
        for (Reward reward : values()) {
            if(reward.count == count && reward.bonus == bonus){
                return reward;
            }
        }
        return NONE;
    }
}
