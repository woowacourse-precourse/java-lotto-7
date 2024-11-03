package lotto;

public enum Prize {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    FAIL(0, 0, 0);

    private final int matchCount;
    private final int bonusMatch;
    private final int prizeAmount;

    Prize(int matchCount, int bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static Prize getPrize(int matchCount, int bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.bonusMatch <= bonusMatch) {
                return prize;
            }
        }
        return FAIL;
    }

    public String getDescription() {
        if (matchCount == 0) {
            return null;
        }

        String description = matchCount + "개 일치";

        if (this == SECOND) {
            description += ", 보너스 볼 일치";
        }

        return description + " (" + String.format("%,d", prizeAmount) + "원)";
    }
}