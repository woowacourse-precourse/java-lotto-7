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
        if (matchCount.equals(SECOND.matchCount) && Boolean.TRUE.equals(isBonusMatch)) {
            return SECOND;
        }
        return switch (matchCount) {
            case 6 -> FIRST;
            case 5 -> THIRD;
            case 4 -> FOURTH;
            case 3 -> FIFTH;
            default -> MISS;
        };
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPrize() {
        return prize;
    }
}
