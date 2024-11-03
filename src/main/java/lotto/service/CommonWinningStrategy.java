package lotto.service;

public enum CommonWinningStrategy {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 3000);

    private final int match;
    private final int money;

    CommonWinningStrategy(int match, int money) {
        this.match = match;
        this.money = money;
    }
}
