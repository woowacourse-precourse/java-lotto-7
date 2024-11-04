package lotto.model;

public enum LottoPrize {
    MATCH_COUNT_3(3, 5000),
    MATCH_COUNT_4(4, 50000),
    MATCH_COUNT_5(5, 1500000),
    MATCH_COUNT_5_WITH_BONUS(7, 30000000),
    MATCH_COUNT_6(6, 2000000000);

    private static final int BONUS_MATCH_COUNT = 5;

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize findByMatchCount(int matchCount, boolean hasBonus) {
        if (hasBonus && matchCount == BONUS_MATCH_COUNT) {
            return MATCH_COUNT_5_WITH_BONUS;
        }
        return switch (matchCount) {
            case 3 -> MATCH_COUNT_3;
            case 4 -> MATCH_COUNT_4;
            case 5 -> MATCH_COUNT_5;
            case 6 -> MATCH_COUNT_6;
            default -> null;
        };
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
