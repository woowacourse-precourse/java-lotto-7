package lotto.enums;

public enum WinRank {
    NONE(0, 0), FIRST(2000000000, 1), SECOND(30000000, 2), THIRD(1500000, 3), FOURTH(50000, 4), FIFTH(5000, 5);

    private final int prize;
    private final int value;

    WinRank(int prize, int value) {
        this.prize = prize;
        this.value = value;
    }

    public int getPrize() {
        return prize;
    }

    public int getValue() {
        return prize;
    }
}
