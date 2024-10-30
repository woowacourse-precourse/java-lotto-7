package lotto.model;

public enum Result {
    FIRST(6,2000000000,false),
    SECOND(5,30000000,true),
    THIRD(5,1500000,false),
    FORTH(4,50000,false),
    FIFTH(3,5000,false);

    private int matchCount;
    private int prizeMoney;
    private boolean isBonusMatch;

    Result(int matchCount, int prizeMoney, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonusMatch = isBonusMatch;
    }
}
