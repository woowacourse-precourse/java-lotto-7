package lotto.domain;

public enum Prize {
    FIRST_PLACE(6, false, 2_000_000_000L),
    SECOND_PLACE(5, true, 30_000_000L),
    THIRD_PLACE(5, false, 1_500_000L),
    FOURTH_PLACE(4, false, 50_000L),
    FIFTH_PLACE(3, false, 5_000L),
    UNRANKED(0, false, 0L);

    private final int matchCount;
    private final boolean bonusRequired;
    private final long prizeAmount;

    Prize(Integer matchCount, boolean bonusRequired, Long prizeAmount) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prizeAmount = prizeAmount;
    }

    public static Prize getPrizeByRank(Rank rank) {
        if (rank == Rank.FIRST_PLACE) {
            return Prize.FIRST_PLACE;
        }
        if (rank == Rank.SECOND_PLACE) {
            return Prize.SECOND_PLACE;
        }
        if (rank == Rank.THIRD_PLACE) {
            return Prize.THIRD_PLACE;
        }
        if (rank == Rank.FOURTH_PLACE) {
            return Prize.FOURTH_PLACE;
        }
        if (rank == Rank.FIFTH_PLACE) {
            return Prize.FIFTH_PLACE;
        }
        return UNRANKED;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusRequired() {
        return bonusRequired;
    }
}
