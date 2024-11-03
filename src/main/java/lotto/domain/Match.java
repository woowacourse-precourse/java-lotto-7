package lotto.domain;

public enum Match {
    SIX_MATCH(2_000_000_000),
    FIVE_AND_BONUS_MATCH(30_000_000),
    FIVE_MATCH_ONLY(1_500_000),
    FOUR_MATCH(50_000),
    THREE_MATCH(5_000),
    NO_MATCH(0);

    private final long prizeAmount;

    Match(long prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}