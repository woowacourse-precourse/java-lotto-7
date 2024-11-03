package lotto.domain;

public enum MatchResult {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchingCount;
    private final int prizeAmount;

    MatchResult(int matchingCount, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public int matchingCount() {
        return matchingCount;
    }
    public int prizeAmount() {
        return prizeAmount;
    }
}
