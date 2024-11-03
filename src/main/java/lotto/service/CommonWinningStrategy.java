package lotto.service;

public enum CommonWinningStrategy {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FORTH(4, 50000, false),
    FIFTH(3, 3000, false);

    private final int match;
    private final int money;
    private final boolean bonusMatch;

    CommonWinningStrategy(int match, int money, boolean bonusMatch) {
        this.match = match;
        this.money = money;
        this.bonusMatch = bonusMatch;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
