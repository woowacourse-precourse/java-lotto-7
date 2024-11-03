package lotto.model;

public enum LottoRank {
    NONE(0,false,0),
    FIFTH(3,false,5000),
    FOURTH(4,false,50000),
    THIRD(5,false,1500000),
    SECOND(5,true,30000000),
    FIRST(6,false,2000000000);

    private final int matchCount;
    private final boolean isMatchBonusBall;
    private final int prize;

    LottoRank(int matchCount, boolean isMatchBonusBall, int prize){
        this.matchCount = matchCount;
        this.isMatchBonusBall=isMatchBonusBall;
        this.prize = prize;
    }
}
