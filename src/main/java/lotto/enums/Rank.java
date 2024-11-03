package lotto.enums;

public enum Rank {
    NONE(0, 0, "0개 일치"),
    THREE_MATCH(3, 5000, "3개 일치"),
    FOUR_MATCH(4, 50000, "4개 일치"),
    FIVE_MATCH(5, 1500000, "5개 일치"),
    FIVE_MATCH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String description;

    Rank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == FIVE_MATCH.matchCount && matchBonus) {
            return FIVE_MATCH_BONUS;
        }
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank != FIVE_MATCH_BONUS) {
                return rank;
            }
        }
        return Rank.NONE;
    }
}