package lotto.enums;

public enum WinRank {
    NONE(0, 0, 0),
    FIRST(2000000000, 6, 1),
    SECOND(30000000, 7, 2),
    THIRD(1500000, 5, 3),
    FOURTH(50000, 4, 4),
    FIFTH(5000, 3, 5);

    private final int prize;
    private final int matchNumberCount;
    private final int value;

    WinRank(int prize, int matchNumberCount, int value) {
        this.prize = prize;
        this.matchNumberCount = matchNumberCount;
        this.value = value;
    }

    public int getPrize() {
        return prize;
    }

    public int getValue() {
        return value;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public static WinRank fromMatchNumberCount(int matchNumberCount) {
        for (WinRank rank : WinRank.values()) {
            if (rank.getMatchNumberCount() == matchNumberCount) {
                return rank;
            }
        }
        return NONE;
    }
}
