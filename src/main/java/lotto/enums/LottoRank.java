package lotto.enums;

public enum LottoRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    private final boolean hasBonus;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonus = false;
    }

    LottoRank(int matchCount, int prize, boolean hasBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank valueOfMatchCount(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        return FIFTH;
    }
}
