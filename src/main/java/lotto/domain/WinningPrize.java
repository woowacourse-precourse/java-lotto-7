package lotto.domain;


public enum WinningPrize {
    FIFTH_PRIZE(3, 5_000, "3개 일치"),
    FOURTH_PRIZE(4, 50_000, "4개 일치"),
    THIRD_PRIZE(5, 1_500_000, "5개 일치"),
    SECOND_PRIZE(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST_PRIZE(6, 2_000_000_000, "6개 일치"),
    NONE_PRIZE(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String description;

    WinningPrize(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static WinningPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST_PRIZE;
        }
        if (matchCount == 5 && matchBonus) {
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
        return NONE_PRIZE;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}