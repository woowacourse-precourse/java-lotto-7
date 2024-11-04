package lotto.model;

public enum PrizeAmount {
    FIRST(2000000000),   // 1등 상금
    SECOND(30000000),    // 2등 상금
    THIRD(1500000),      // 3등 상금
    FOURTH(50000),       // 4등 상금
    FIFTH(5000),         // 5등 상금
    NONE(0);             // 꽝

    private final long prizeAmount;

    PrizeAmount(long prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}