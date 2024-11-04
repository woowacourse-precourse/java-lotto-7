package lotto;

public enum LottoPrize {
    FIFTH_PLACE(3, "5,000", 5_000, "3개 일치"),
    FOURTH_PLACE(4, "50,000", 50_000, "4개 일치"),
    THIRD_PLACE(5, "1,500,000", 1_500_000, "5개 일치"),
    SECOND_PLACE(5, "30,000,000", 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST_PLACE(6, "2,000,000,000", 2_000_000_000, "6개 일치");

    private final int winningNumberMatchCount;
    private final String prizeMoney;
    private final long realPrizeMoney;
    private final String description;

    LottoPrize(int winningNumberMatchCount, String prizeMoney, long realPrizeMoney, String description) {
        this.winningNumberMatchCount = winningNumberMatchCount;
        this.prizeMoney = prizeMoney;
        this.realPrizeMoney = realPrizeMoney;
        this.description = description;
    }

    public int getWinningNumberMatchCount() {
        return winningNumberMatchCount;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public long getRealPrizeMoney() {
        return realPrizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
