package lotto;

public enum MatchCount {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_WITH_BONUS(30000000),
    SIX(2000000000);

    private int prizeMoney;

    private MatchCount(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
