package lotto;

public enum LottoPrize {
    FIFTH_PLACE(3, "5,000", "3개 일치"),
    FOURTH_PLACE(4, "50,000", "4개 일치"),
    THIRD_PLACE(5, "1,500,000", "5개 일치"),
    SECOND_PLACE(5, "30,000,000", "5개 일치, 보너스 볼 일치"),
    FIRST_PLACE(6, "2,000,000,000", "6개 일치");

    private final int winningNumberMatchCount;
    private final String prizeMoney;
    private final String description;

    LottoPrize(int winningNumberMatchCount, String prizeMoney, String description) {
        this.winningNumberMatchCount = winningNumberMatchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getWinningNumberMatchCount() {
        return winningNumberMatchCount;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
