package lotto.domain.enums;

public enum Stats {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원) - "),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원) - "),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_MATCH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH_BONUS(6, 200000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final int prize;

    private final String description;

    Stats(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static Stats valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_BONUS;
        }
        for (Stats stat : values()) {
            if (stat.matchCount == matchCount && stat != FIVE_MATCH_BONUS) {
                return stat;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
