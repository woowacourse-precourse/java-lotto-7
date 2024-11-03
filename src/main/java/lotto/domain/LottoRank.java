package lotto.domain;

public enum LottoRank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    ;
    private final int hitCount;
    private final boolean isBonusHit;
    private final int prize;

    LottoRank(int hitCount, boolean isBonusHit, int prize) {
        this.hitCount = hitCount;
        this.isBonusHit = isBonusHit;
        this.prize = prize;
    }

    public static LottoRank of(int hitLottoNumbers, boolean isBonusNumberHit) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.hitCount == hitLottoNumbers && (!lottoRank.isBonusHit || isBonusNumberHit)) {
                return lottoRank;
            }
        }
        return null;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isBonusHit() {
        return isBonusHit;
    }

    public int getPrize() {
        return prize;
    }
}
