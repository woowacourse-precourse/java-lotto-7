package lotto.model;

import java.util.HashMap;

public enum Rank {
    NO_RANK_ZERO(0, 0, 0L),
    FIFTH_RANK(3, 0, 5_000L),
    FOURTH_RANK(4, 0,50_000L),
    THIRD_RANK(5, 0, 1_500_000L),
    SECOND_RANK(5, 1,30_000_000L),
    FIRST_RANK(6, 0,2_000_000_000L);

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

    public int getBonusCount() { return bonusCount; }

    public static HashMap<Rank, Integer> initRank(){
        HashMap<Rank, Integer> initHashMap = new HashMap<>();
        for(Rank rank: Rank.values()){
            initHashMap.put(rank, 0);
        }
        return initHashMap;
    }

    public static Rank getRank(int correctCount, int bonusCount){
        if(isSecondRank(correctCount, bonusCount)){
            return Rank.SECOND_RANK;
        }

        for(Rank rank: Rank.values()){
            if(rank.correctCount == correctCount){
                return rank;
            }
        }
        return Rank.NO_RANK_ZERO;
    }

    private static boolean isSecondRank(int correctCount, int bonusCount){
        return correctCount == SECOND_RANK.correctCount && bonusCount == SECOND_RANK.bonusCount;
    }

}
