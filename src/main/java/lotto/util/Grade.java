package lotto.util;

public enum Grade {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);

    private final int prizeMoney;

    Grade(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
