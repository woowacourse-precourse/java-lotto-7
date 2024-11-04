package lotto.domain.rule;

public enum WinningRules {

    NO_MATCH(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int winningMatchCount;
    private final int prize;

    WinningRules(int winningMatchCount, int prize) {
        this.winningMatchCount = winningMatchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return winningMatchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningRules valueOf(int winningMatchCount, boolean bonusMatch) {
        if (winningMatchCount == SIX_MATCH.getMatchCount()) return SIX_MATCH;
        if (winningMatchCount == FIVE_MATCH_WITH_BONUS.getMatchCount() && bonusMatch) return FIVE_MATCH_WITH_BONUS;
        if (winningMatchCount == FIVE_MATCH.getMatchCount()) return FIVE_MATCH;
        if (winningMatchCount == FOUR_MATCH.getMatchCount()) return FOUR_MATCH;
        if (winningMatchCount == THREE_MATCH.getMatchCount()) return THREE_MATCH;
        return NO_MATCH;
    }

}
