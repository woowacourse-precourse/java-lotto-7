package lotto.constants;

public enum WinnerConstants {
    FIRST_WINNER(1, 6, 2000000000, "6개 일치"),
    SECOND_WINNER(2, 5, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD_WINNER(3, 5, 1500000, "5개 일치"),
    FOURTH_WINNER(4, 4, 50000, "4개 일치"),
    FIFTH_WINNER(5, 3, 5000, "3개 일치");

    private final int rank;
    private final int matchCount;
    private final long prizeMoney;
    private final String message;

    WinnerConstants(final int rank, final int matchCount, final long prizeMoney, final String message) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
