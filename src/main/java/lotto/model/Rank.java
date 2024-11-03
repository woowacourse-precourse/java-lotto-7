package lotto.model;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치", true),
    THIRD(5, 1500000, "5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(3, 5000, "3개 일치"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String description;
    private final boolean bonusRequired;

    Rank(int matchCount, int prize, String description) {
        this(matchCount, prize, description, false);
    }

    Rank(int matchCount, int prize, String description, boolean bonusRequired) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
        this.bonusRequired = bonusRequired;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.bonusRequired || bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }
}
