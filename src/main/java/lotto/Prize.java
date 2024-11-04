package lotto;

public enum Prize {
    FIRST(2_000_000_000, false, 6),
    SECOND(30_000_000, true, 5),
    THIRD(1_500_000, false, 5),
    FOURTH(50_000, false, 4),
    FIFTH(5_000, false, 3),
    NO_PRIZE(0, false, 0);

    private static final int MIN_Match = 3;
    private final int money;
    private final boolean bonusMatch;
    private final int matchCount;

    Prize(int money, boolean bonusMatch, int matchCount) {
        this.money = money;
        this.bonusMatch = bonusMatch;
        this.matchCount = matchCount;
    }

    public int getMoney() {
        return money;
    }

    public static Prize parse(int matchCount, boolean hasBonus) {
        if (matchCount < MIN_Match) {
            return NO_PRIZE;
        }
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && prize.bonusMatch == hasBonus) {
                return prize;
            }
        }
        return NO_PRIZE;
    }
}
