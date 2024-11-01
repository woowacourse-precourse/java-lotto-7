package lotto;

public enum WinningInfo {
    FIRST_WINNER("6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND_WINNER("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD_WINNER("5개 일치 (1,500,000원)", 1_500_000),
    FOURTH_WINNER("4개 일치 (50,000원)", 50_000),
    FIFTH_WINNER("3개 일치 (5,000원)", 5_000);

    private final String info;
    private final int winningAmount;

    WinningInfo(String info, int winningAmount) {
        this.info = info;
        this.winningAmount = winningAmount;
    }

    public String getInfo() {
        return info;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

}
