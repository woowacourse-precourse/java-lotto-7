package lotto;

public enum Rank {
    THREE(5000, "3개 일치"),
    FOUR(50000, "4개 일치"),
    FIVE(1500000, "5개 일치"),
    FIVE_AND_BONUS(30000000, "5개 일치, 보너스 볼 일치"),
    SIX(2000000000, "6개 일치");

    private final int prizeMoney;
    private final String matchInfo;

    Rank(int prizeMoney, String matchInfo) {
        this.prizeMoney = prizeMoney;
        this.matchInfo = matchInfo;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMatchInfo() {
        return matchInfo;
    }
}
