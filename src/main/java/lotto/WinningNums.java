package lotto;

public enum WinningNums {
    SIX(6, 2_000_000_000, "6개 일치"),
    FIVE_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    THREE(3, 5_000, "3개 일치"),
    NONE(0, 0, "");

    private final int matchingCount;
    private final int prize;
    private final String name;

    WinningNums(int matchingCount, int prize, String name) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.name = name;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getName() {
        return name;
    }

    public static WinningNums checkRank(int matchingCount) {
        for (WinningNums rank : values()) {
            if (rank.getMatchingCount() == matchingCount) {
                return rank;
            }
        }
        return NONE;
    }
}