package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0); // 일치하지 않는 경우

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
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
        return MISS;
    }
}