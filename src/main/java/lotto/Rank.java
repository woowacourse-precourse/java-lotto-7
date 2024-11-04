package lotto;

import lotto.dto.WinningResult;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean isBonusMatched;
    private final int prize;

    Rank(int matchCount, boolean isBonusMatched, int prize) {
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public Rank getRank(WinningResult result) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == result.getMatchCount() && rank.isBonusMatched == isBonusMatched) {
                return rank;
            }
        }

        return NONE;
    }
}
