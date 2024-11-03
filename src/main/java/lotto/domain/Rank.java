package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, false, "6개 일치"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, false, "5개 일치"),
    FOURTH(4, 50_000, false, "4개 일치"),
    FIFTH(3, 5_000, false, "3개 일치"),
    NONE(0, 0, false, "미당첨");

    private final int matchCount;
    private final int prize;
    private final boolean needBonusMatch;
    private final String description;

    Rank(int matchCount, int prize, boolean needBonusMatch, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.needBonusMatch = needBonusMatch;
        this.description = description;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && !rank.needBonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}