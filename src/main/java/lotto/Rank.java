package lotto;

import lotto.dto.WinningResult;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0, 0, 0);

    private final int matchCount;
    private final int bonusMatchCount;
    private final int prize;

    Rank(int matchCount, int bonusMatchCount, int prize) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
        this.prize = prize;
    }

    public Rank getRank(WinningResult result) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == result.getMatchCount() && rank.bonusMatchCount >= bonusMatchCount) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
