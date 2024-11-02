package lotto.constant;

import lotto.model.MatchResult;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0);


    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    Prize(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    Prize(int prize) {
        this(0, false, prize);
    }

    public static Prize getRank(MatchResult matchResult) {
        int matchCount = matchResult.getMatchCount();
        boolean bonusMatch = matchResult.isMatchBonus();

        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5 && !bonusMatch) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }
    public boolean isBonusMatch() {
        return bonusMatch;
    }
    public int getPrize() {
        return prize;
    }
}
