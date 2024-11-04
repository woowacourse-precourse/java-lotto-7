package lotto;

public enum LottoRank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && (!lottoRank.matchBonus || matchBonus)) {
                return lottoRank;
            }
        }
        return NONE;
    }

    @Override
    public String toString() {
        if (matchBonus) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + prize + "원)";
        }
        return matchCount + "개 일치 (" + prize + "원)";
    }
}
