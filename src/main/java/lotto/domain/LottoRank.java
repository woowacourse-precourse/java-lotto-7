package lotto.domain;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchingCount;
    private final int prize;

    LottoRank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LottoRank getRank(int matchingCount, boolean matchingBonus) {
        if (matchingCount == 6) {
            return FIRST;
        }
        if (matchingCount == 5 && matchingBonus) {
            return SECOND;
        }
        if (matchingCount == 5) {
            return THIRD;
        }
        if (matchingCount == 4) {
            return FOURTH;
        }
        if (matchingCount == 3) {
            return FIFTH;
        }

        return MISS;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }
}
