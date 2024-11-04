package lotto.model;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final long prize;

    LottoRank(int matchCount, boolean hasBonus, long prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.isEqualsRank(matchCount, hasBonus)) {
                return lottoRank;
            }
        }
        return NONE;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    private boolean isEqualsRank(int matchCount, boolean hasBonus) {
        return this.matchCount == matchCount && this.hasBonus == hasBonus;
    }

}
