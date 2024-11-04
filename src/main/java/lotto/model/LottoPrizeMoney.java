package lotto.model;

public enum LottoPrizeMoney {

    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000), MISS(0);

    private final int prizeMoney;

    LottoPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
