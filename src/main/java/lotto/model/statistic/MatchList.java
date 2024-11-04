package lotto.model.statistic;

public enum MatchList {
    THREE_NUMBERS_MATCH(3, false),
    FOUR_NUMBERS_MATCH(4, false),
    FIVE_NUMBERS_MATCH(5, false),
    FIVE_AND_BONUS_NUMBERS_MATCH(6, true),
    SIX_NUMBERS_MATCH(6, false);

    private final int matchNumber;
    private final boolean isBonusMatch;

    MatchList(final int matchNumber, final boolean isBonusMatch) {
        this.matchNumber = matchNumber;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}
