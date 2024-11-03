package lotto.Domain;

public enum WinningRules {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NO_WIN(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    WinningRules(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static WinningRules valueOf(int matchCount, boolean bonusMatch) {
        for (WinningRules rule : values()) {
            if (rule.matchCount == matchCount && rule.bonusMatch == bonusMatch) {
                return rule;
            }
        }
        if (matchCount >= FIFTH.matchCount) {
            return FIFTH;
        }
        return NO_WIN;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
