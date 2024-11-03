package lotto.model;

public enum Reward {
    FIRST(6,false,2_000_000_000,1),
    SECOND(5,true,30_000_000,2),
    THIRD(5,false,1_500_000,3),
    FOURTH(4,false,50_000,4),
    FIFTH(3,false,5_000,5),
    NONE(0,false,0,6);

    private final int count;
    private final boolean bonus;
    private final int prize;

    private final int rank;

    Reward(int count, boolean bonus, int prize, int rank) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
        this.rank = rank;
    }

    public int getPrize() {
        return prize;
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
