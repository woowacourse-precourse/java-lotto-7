package lotto.Model;

public enum LottoPrizeMoney {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int prizeMoney;
    private final int matchNumber;

    LottoPrizeMoney(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNumber() {
        return matchNumber;
    }
}
