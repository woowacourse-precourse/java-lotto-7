package lotto.domain;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0); // 당첨되지 않은 경우

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    LottoPrize(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize valueOf(int matchCount, boolean bonusMatch) {
        for (LottoPrize prize : values()) {
            if (prize.matchCount == matchCount && prize.requiresBonus == bonusMatch) {
                return prize;
            }
        }
        return NONE;
    }
}