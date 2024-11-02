package lotto.domain.prize;

public enum PrizeMoney {

    PRIZE_FIRST(2000000000),
    PRIZE_SECOND(30000000),
    PRIZE_THIRD(1500000),
    PRIZE_FOURTH(50000),
    PRIZE_FIFTH(5000);

    private int prizeMoney;

    PrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
