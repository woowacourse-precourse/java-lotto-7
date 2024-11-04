package lotto;

public enum Prize {
    FIFTH(3, "3개 일치 ", 5000),
    FOURTH(4,"4개 일치 ", 50000),
    THIRD(5, "5개 일치 ", 1500000),
    SECOND(5, "5개 일치, 보너스 볼 일치 ", 30000000),
    FIRST(6, "6개 일치 ", 2000000000);

    private final int winningCount;
    private final String prizeCondition;
    private final int prizeMoney;

    Prize(int winningCount, String prizeCondition, int prizeMoney) {
        this.winningCount = winningCount;
        this.prizeCondition = prizeCondition;
        this.prizeMoney = prizeMoney;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public String getPrizeCondition() {
        return prizeCondition;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
