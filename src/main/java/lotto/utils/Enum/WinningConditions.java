package lotto.utils.Enum;

public enum WinningConditions {

    THREE("5등", 3, 5_000),
    FOUR("4등", 4, 50_000),
    FIVE("3등", 5, 1_500_000),
    FIVE_BONUS("2등", 5, 30_000_000),
    SIX("1등", 6, 2_000_000_000);

    private final String rank;
    private final int ballCount;
    private final int prizeMoney;

    WinningConditions(String rank, int ballCount, int prizeMoney) {
        this.rank = rank;
        this.ballCount = ballCount;
        this.prizeMoney = prizeMoney;
    }

    public String getRank() {
        return rank;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
