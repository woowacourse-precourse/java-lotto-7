package lotto.model;

import java.util.HashMap;

public enum Rank {
    NO_RANK_ZERO(0, 0, 0L),
    FIFTH_RANK(3, 0, 5_000L),
    FIFTH_RANK_BONUS(3, 1, 5_000L),
    FOURTH_RANK(4, 0,50_000L),
    FOURTH_RANK_BONUS(4, 1,50_000L),
    THIRD_RANK(5, 0, 1_500_000L),
    THIRD_RANK_BONUS(5, 1,30_000_000L),
    FIRST_RANK(6, 0,2_000_000_000L),
    FIRST_RANK_BONUS(6, 1,2_000_000_000L);

    private final int correctCount;
    private final int bonusCount;
    private final long prize;

    Rank(int correctCount, int bonusCount, long prize) {
        this.correctCount = correctCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getPrize() {
        return prize;
    }

    public static HashMap<Rank, Integer> initRank(){
        HashMap<Rank, Integer> inithashMap = new HashMap<>();
        for(Rank rank: Rank.values()){
            inithashMap.put(rank, 0);
        }
        return inithashMap;
    }

    public static Rank getRank(int correctCount, int bonusCount){
        for(Rank rank: Rank.values()){
            if(rank.correctCount == correctCount && rank.bonusCount == bonusCount){
                return rank;
            }
        }
        return Rank.NO_RANK_ZERO;
    }
}
