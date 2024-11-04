package lotto;

import java.util.Arrays;

public enum PrizeRank {
    NONE(0, 0, false, 0),
    FIFTH(5, 3, false, 5_000),
    FOURTH(4, 4, false, 50_000),
    THIRD(3, 5, false, 1_500_000),
    SECOND(2, 5, true, 30_000_000),
    FIRST(1, 6, false, 2_000_000_000);

    private final int rank;
    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    PrizeRank(int rank, int matchCount, boolean bonusMatch, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static PrizeRank fromRank(int rank) {
        return Arrays.stream(values())
                .filter(prizeRank -> prizeRank.getRank() == rank)
                .findFirst()
                .orElse(NONE);
    }

    public static PrizeRank fromMatchCountAndBonus(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(prizeRank -> prizeRank.getMatchCount() == matchCount)
                .findFirst()
                .map(prizeRank -> {
                    if (prizeRank == THIRD && bonusMatch) {
                        return SECOND;
                    }
                    return prizeRank;
                })
                .orElse(NONE);
    }

    public boolean isSecondRank() {
        return this == SECOND;
    }
}