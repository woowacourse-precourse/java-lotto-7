package lotto.model.domain;

public enum LottoRank {
    DEFAULT(0,0,0, false, false),
    FIFTH(5,3, 5_000, false, false),
    FOURTH(4,4, 50_000, false, false),
    THIRD(3,5, 1_500_000, true, false),
    SECOND(2,5, 30_000_000, true, true),
    FIRST(1,6, 2_000_000_000, false, false);
    private final int rank;
    private final int matchCount;
    private final long prize;
    private final boolean confirmBonus;
    private final boolean requiredBonus;

    LottoRank(int rank, int matchCount, long prize, boolean confirmBonus, boolean requiredBonus) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
        this.confirmBonus = confirmBonus;
        this.requiredBonus = requiredBonus;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isConfirmBonus() {
        return confirmBonus;
    }

    public boolean isRequiredBonus() {
        return requiredBonus;
    }

    public static LottoRank findByRank(int rank) {
        for(LottoRank lottoRank : LottoRank.values()) {
            if(lottoRank.getRank() == rank) {
                return lottoRank;
            }
        }
        return LottoRank.DEFAULT;
    }
}
