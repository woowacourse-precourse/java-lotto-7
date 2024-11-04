package lotto.model;

public enum LottoRank {
    NONE(0,false,0),
    FIFTH(3,false,5000),
    FOURTH(4,false,50000),
    THIRD(5,false,1500000),
    SECOND(5,true,30000000),
    FIRST(6,false,2000000000);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int prize;

    LottoRank(int matchCount, boolean hasBonusNumber, int prize){
        this.matchCount = matchCount;
        this.hasBonusNumber=hasBonusNumber;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank getRank(int matchCount, boolean hasBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.hasBonusNumber == hasBonus) {
                return rank;
            }
        }
        return NONE;
    }
}
