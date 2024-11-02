package lotto.domain;

public enum LottoPrize {
    FIRST_PRIZE(2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PRIZE(1500000, "5개 일치 (1,500,000원)"),
    FOURTH_PRIZE(50000, "4개 일치 (50,000원)"),
    FIFTH_PRIZE(5000, "3개 일치 (5,000원)");

    private final int prizeAmount;
    private final String description;

    LottoPrize(int prizeAmount, String description) {
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public static LottoPrize fromMatchCount(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST_PRIZE;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND_PRIZE;
        }
        if (matchCount == 5) {
            return THIRD_PRIZE;
        }
        if (matchCount == 4) {
            return FOURTH_PRIZE;
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE;
        }
        return null;
    }
}
