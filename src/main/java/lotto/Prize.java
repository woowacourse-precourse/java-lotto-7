package lotto;

public enum Prize {
    THREE_MATCHES(3, 5000, "3개 일치"),
    FOUR_MATCHES(4, 50000, "4개 일치"),
    FIVE_MATCHES(5, 1500000, "5개 일치"),
    FIVE_MATCHES_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCHES(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int prizeAmount;
    private final String description;

    Prize(int matchCount, int prizeAmount, String description) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCHES_WITH_BONUS;
        }
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        return null;
    }
}
