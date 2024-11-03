package lotto.service;

public enum CommonWinningStrategy {
    FIFTH(3, 3000, false),
    FORTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int match;
    private final long money;
    private final boolean bonusMatch;

    CommonWinningStrategy(int match, long money, boolean bonusMatch) {
        this.match = match;
        this.money = money;
        this.bonusMatch = bonusMatch;
    }

    public int getMatch() {
        return match;
    }

    public long getMoney() {
        return money;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
