package lotto.util;

public enum Rank {
    FIRST(6, 2000000000),   // 1등: 6개 번호 일치
    SECOND(5, 30000000),    // 2등: 5개 번호 + 보너스 번호 일치
    THIRD(5, 1500000),      // 3등: 5개 번호 일치
    FOURTH(4, 50000),       // 4등: 4개 번호 일치
    FIFTH(3, 5000),         // 5등: 3개 번호 일치
    NONE(0, 0);             // 당첨되지 않음

    private final int matchCount;  
    private final int prize;        

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank fromMatchCount(int matchCount, boolean hasBonus) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        } else if (matchCount == SECOND.matchCount && hasBonus) {
            return SECOND;
        } else if (matchCount == THIRD.matchCount) {
            return THIRD;
        } else if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        } else if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return NONE;
    }
}