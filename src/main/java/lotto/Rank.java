package lotto;

public enum Rank {

    FRIST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000 ),
    THIRD(5, false, 1_500_000),
    FOURTH(4,false, 50_000),
    FIFTH(3,false, 5_000),
    MISS(0,false,0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    Rank(int matchCount, boolean requiresBonus, int prize){
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }
    public static Rank valueOf(int matchCount, boolean bonusMatch){
        for (Rank rank : values()){
            if (rank.matchCount == matchCount && rank.requiresBonus == bonusMatch){
                return rank;
            }
        }
        return MISS;
    }
    public int getPrize(){
        return prize;
    }

}
