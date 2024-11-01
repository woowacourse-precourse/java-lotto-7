package lotto.model;

public enum Rank {
    FIFTH("5,000", 5000, 3),
    FOURTH("50,000", 50000, 4),
    THIRD("1,500,000", 1500000, 5),
    SECOND("30,000,000", 30000000, 5),
    FIRST("2,000,000,000", 2000000000, 6);

    private final String strPrize;
    private final long prize;
    private final int goal;

    Rank(String strPrize, long prize, int goal) {
        this.strPrize = strPrize;
        this.prize = prize;
        this.goal = goal;
    }

    public String getStrPrize() {
        return strPrize;
    }

    public long getPrize() {
        return prize;
    }

    public int getGoal() {
        return goal;
    }
}
