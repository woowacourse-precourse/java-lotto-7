package lotto;

public enum Rank {
    NONE(0, 0, "낙첨"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치", true),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String description;
    private final boolean needsBonusMatch;

    public String getDescription() {
        return description;
    }

    Rank(int matchCount, int prize, String description) {
        this(matchCount, prize, description, false);
    }

    Rank(int matchCount, int prize, String description, boolean needsBonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
        this.needsBonusMatch = needsBonusMatch;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
