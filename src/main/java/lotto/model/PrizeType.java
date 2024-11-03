package lotto.model;

public enum PrizeType {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000),
    NO_PRIZE(0, false, 0);

    private final int matchNum;
    private final boolean isBonusBallMatch;
    private final int prizeAmount;

    PrizeType(int matchNum, boolean isBonusBallMatch, int prizeAmount) {
        this.matchNum = matchNum;
        this.isBonusBallMatch = isBonusBallMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public boolean getIsBonusBallMatch() {
        return isBonusBallMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

}
