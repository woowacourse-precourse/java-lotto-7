package lotto.domain;

public enum Prize {

    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치");

    private final int matchCount;
    private final boolean requiresBonusMatch;
    private final int prizeAmount;
    private final String message;

    Prize(int matchCount, boolean requiresBonusMatch, int prizeAmount, String message) {
        this.matchCount = matchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && (!prize.requiresBonusMatch || bonusMatch)) {
                return prize;
            }
        }
        return null;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMessage() {
        return message;
    }
}
