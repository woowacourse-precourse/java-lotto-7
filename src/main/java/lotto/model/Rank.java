package lotto.model;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    MISS(-1, 0, "낙첨");


    private final int matchCount;
    private final int prize;
    private final String description;

    Rank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static Rank of(int matchCount, boolean hasBonus) {
        if (FIRST.matchCount == matchCount) {
            return FIRST;
        }
        if (SECOND.matchCount == matchCount && hasBonus) {
            return SECOND;
        }
        if (THIRD.matchCount == matchCount) {
            return THIRD;
        }
        if (FOURTH.matchCount == matchCount) {
            return FOURTH;
        }
        if (FIFTH.matchCount == matchCount) {
            return FIFTH;
        }
        return MISS;
    }
}
