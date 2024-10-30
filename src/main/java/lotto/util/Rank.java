package lotto.util;

public enum Rank {
    FIRST(6, 2000000000, 1),   
    SECOND(5, 30000000, 2),   
    THIRD(5, 1500000, 3),     
    FOURTH(4, 50000, 4),     
    FIFTH(3, 5000, 5),         
    NONE(0, 0, 0);          

    private final int matchCount;
    private final int prize;
    private final int rankOrder;

    Rank(int matchCount, int prize, int rankOrder) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.rankOrder = rankOrder;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getRankOrder() {
        return rankOrder;
    }

    public static Rank fromMatchCount(int matchCount, boolean hasBonus) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && hasBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return NONE;
    }
}
