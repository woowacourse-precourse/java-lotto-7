package lotto.domain.constants;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private final Integer matchCount;
    private final Integer prize;

    Rank(final Integer matchCount, final Integer prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(final Integer matchCount, final Boolean isBonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && Boolean.TRUE.equals(isBonusMatch)) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPrize() {
        return prize;
    }
}
