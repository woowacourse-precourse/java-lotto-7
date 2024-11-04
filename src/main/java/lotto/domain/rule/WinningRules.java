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
        if (winningMatchCount == 6) return SIX_MATCH;
        if (winningMatchCount == 5 && bonusMatch) return FIVE_MATCH_WITH_BONUS;
        if (winningMatchCount == 5) return FIVE_MATCH;
        if (winningMatchCount == 4) return FOUR_MATCH;
        if (winningMatchCount == 3) return THREE_MATCH;
        return NO_MATCH;
    }

}
