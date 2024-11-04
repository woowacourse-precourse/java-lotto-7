package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;

    LottoRank(int matchCount, boolean bonusRequired, int prize) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public static LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        } else if (matchCount == 5 && bonusMatch) {
            return SECOND;
        } else if (matchCount == 5) {
            return THIRD;
        } else if (matchCount == 4) {
            return FOURTH;
        } else if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
