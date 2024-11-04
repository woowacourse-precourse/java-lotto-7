package lotto.domain;

public enum LottoPrize {

    NO_MATCH(0, 0, "당첨되지 않음"),
    MATCH_3(3, 5_000, "3개 일치 (5,000원)"),
    MATCH_4(4, 50_000, "4개 일치 (50,000원)"),
    MATCH_5(5, 1_500_000, "5개 일치 (1,500,000원)"),
    MATCH_5_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoPrize(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoPrize valueOf(int matchCount, boolean matchBonus) {
        if (MATCH_5.getMatchCount() == matchCount && matchBonus) {
            return MATCH_5_BONUS;
        }
        if (matchCount < 3) {
            return NO_MATCH;
        }
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
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
