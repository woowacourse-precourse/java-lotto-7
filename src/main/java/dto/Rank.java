package dto;

public enum Rank {
    FIRST,SECOND,THIRD,FOURTH,FIFTH,NONE;

    public static Rank valueOfMatchCount(int count, boolean bonusMatched) {
        if (count == 6) return FIRST;
        if (count == 5 && bonusMatched) return SECOND;
        if (count == 5) return THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;
        return NONE;
    }
}
